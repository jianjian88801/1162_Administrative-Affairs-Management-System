




















package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 会议室申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huiyishiShenqing")
public class HuiyishiShenqingController {
    private static final Logger logger = LoggerFactory.getLogger(HuiyishiShenqingController.class);

    @Autowired
    private HuiyishiShenqingService huiyishiShenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private HuiyishiService huiyishiService;
    @Autowired
    private JiaoshiService jiaoshiService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = huiyishiShenqingService.queryPage(params);

        //字典表数据转换
        List<HuiyishiShenqingView> list =(List<HuiyishiShenqingView>)page.getList();
        for(HuiyishiShenqingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuiyishiShenqingEntity huiyishiShenqing = huiyishiShenqingService.selectById(id);
        if(huiyishiShenqing !=null){
            //entity转view
            HuiyishiShenqingView view = new HuiyishiShenqingView();
            BeanUtils.copyProperties( huiyishiShenqing , view );//把实体数据重构到view中

                //级联表
                HuiyishiEntity huiyishi = huiyishiService.selectById(huiyishiShenqing.getHuiyishiId());
                if(huiyishi != null){
                    BeanUtils.copyProperties( huiyishi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuiyishiId(huiyishi.getId());
                }
                //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(huiyishiShenqing.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuiyishiShenqingEntity huiyishiShenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huiyishiShenqing:{}",this.getClass().getName(),huiyishiShenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("教师".equals(role))
            huiyishiShenqing.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HuiyishiShenqingEntity> queryWrapper = new EntityWrapper<HuiyishiShenqingEntity>()
            .eq("jiaoshi_id", huiyishiShenqing.getJiaoshiId())
            .eq("huiyishi_id", huiyishiShenqing.getHuiyishiId())
            .eq("huiyishi_shenqing_yesno_types", huiyishiShenqing.getHuiyishiShenqingYesnoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuiyishiShenqingEntity huiyishiShenqingEntity = huiyishiShenqingService.selectOne(queryWrapper);
        if(huiyishiShenqingEntity==null){
            huiyishiShenqing.setInsertTime(new Date());
            if(huiyishiShenqing.getHuiyishiShenqingYesnoTypes() == null){
                huiyishiShenqing.setHuiyishiShenqingYesnoTypes(1);
            }
            huiyishiShenqing.setCreateTime(new Date());
            huiyishiShenqingService.insert(huiyishiShenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuiyishiShenqingEntity huiyishiShenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huiyishiShenqing:{}",this.getClass().getName(),huiyishiShenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("教师".equals(role))
//            huiyishiShenqing.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<HuiyishiShenqingEntity> queryWrapper = new EntityWrapper<HuiyishiShenqingEntity>()
            .notIn("id",huiyishiShenqing.getId())
            .andNew()
            .eq("jiaoshi_id", huiyishiShenqing.getJiaoshiId())
            .eq("huiyishi_id", huiyishiShenqing.getHuiyishiId())
            .eq("insert_time", huiyishiShenqing.getInsertTime())
            .eq("huiyishi_shenqing_yesno_types", huiyishiShenqing.getHuiyishiShenqingYesnoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuiyishiShenqingEntity huiyishiShenqingEntity = huiyishiShenqingService.selectOne(queryWrapper);
        if(huiyishiShenqingEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      huiyishiShenqing.set
            //  }
            huiyishiShenqingService.updateById(huiyishiShenqing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        huiyishiShenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<HuiyishiShenqingEntity> huiyishiShenqingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HuiyishiShenqingEntity huiyishiShenqingEntity = new HuiyishiShenqingEntity();
//                            huiyishiShenqingEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //申请教师 要改的
//                            huiyishiShenqingEntity.setHuiyishiId(Integer.valueOf(data.get(0)));   //申请办公物资 要改的
//                            huiyishiShenqingEntity.setInsertTime(date);//时间
//                            huiyishiShenqingEntity.setHuiyishiShenqingYesnoTypes(Integer.valueOf(data.get(0)));   //申请结果 要改的
//                            huiyishiShenqingEntity.setCreateTime(date);//时间
                            huiyishiShenqingList.add(huiyishiShenqingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        huiyishiShenqingService.insertBatch(huiyishiShenqingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = huiyishiShenqingService.queryPage(params);

        //字典表数据转换
        List<HuiyishiShenqingView> list =(List<HuiyishiShenqingView>)page.getList();
        for(HuiyishiShenqingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuiyishiShenqingEntity huiyishiShenqing = huiyishiShenqingService.selectById(id);
            if(huiyishiShenqing !=null){


                //entity转view
                HuiyishiShenqingView view = new HuiyishiShenqingView();
                BeanUtils.copyProperties( huiyishiShenqing , view );//把实体数据重构到view中

                //级联表
                    HuiyishiEntity huiyishi = huiyishiService.selectById(huiyishiShenqing.getHuiyishiId());
                if(huiyishi != null){
                    BeanUtils.copyProperties( huiyishi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuiyishiId(huiyishi.getId());
                }
                //级联表
                    JiaoshiEntity jiaoshi = jiaoshiService.selectById(huiyishiShenqing.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody HuiyishiShenqingEntity huiyishiShenqing, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huiyishiShenqing:{}",this.getClass().getName(),huiyishiShenqing.toString());
        Wrapper<HuiyishiShenqingEntity> queryWrapper = new EntityWrapper<HuiyishiShenqingEntity>()
            .eq("jiaoshi_id", huiyishiShenqing.getJiaoshiId())
            .eq("huiyishi_id", huiyishiShenqing.getHuiyishiId())
            .eq("huiyishi_shenqing_yesno_types", huiyishiShenqing.getHuiyishiShenqingYesnoTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuiyishiShenqingEntity huiyishiShenqingEntity = huiyishiShenqingService.selectOne(queryWrapper);
        if(huiyishiShenqingEntity==null){
            huiyishiShenqing.setInsertTime(new Date());
            huiyishiShenqing.setHuiyishiShenqingYesnoTypes(1);
            huiyishiShenqing.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      huiyishiShenqing.set
        //  }
        huiyishiShenqingService.insert(huiyishiShenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
