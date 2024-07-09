




















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
 * 办公物资申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bangongwuziShenqing")
public class BangongwuziShenqingController {
    private static final Logger logger = LoggerFactory.getLogger(BangongwuziShenqingController.class);

    @Autowired
    private BangongwuziShenqingService bangongwuziShenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private BangongwuziService bangongwuziService;
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
        PageUtils page = bangongwuziShenqingService.queryPage(params);

        //字典表数据转换
        List<BangongwuziShenqingView> list =(List<BangongwuziShenqingView>)page.getList();
        for(BangongwuziShenqingView c:list){
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
        BangongwuziShenqingEntity bangongwuziShenqing = bangongwuziShenqingService.selectById(id);
        if(bangongwuziShenqing !=null){
            //entity转view
            BangongwuziShenqingView view = new BangongwuziShenqingView();
            BeanUtils.copyProperties( bangongwuziShenqing , view );//把实体数据重构到view中

                //级联表
                BangongwuziEntity bangongwuzi = bangongwuziService.selectById(bangongwuziShenqing.getBangongwuziId());
                if(bangongwuzi != null){
                    BeanUtils.copyProperties( bangongwuzi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBangongwuziId(bangongwuzi.getId());
                }
                //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(bangongwuziShenqing.getJiaoshiId());
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
    public R save(@RequestBody BangongwuziShenqingEntity bangongwuziShenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bangongwuziShenqing:{}",this.getClass().getName(),bangongwuziShenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("教师".equals(role))
            bangongwuziShenqing.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BangongwuziShenqingEntity> queryWrapper = new EntityWrapper<BangongwuziShenqingEntity>()
            .eq("jiaoshi_id", bangongwuziShenqing.getJiaoshiId())
            .eq("bangongwuzi_id", bangongwuziShenqing.getBangongwuziId())
            .eq("bangongwuzi_shenqing_yesno_types", bangongwuziShenqing.getBangongwuziShenqingYesnoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BangongwuziShenqingEntity bangongwuziShenqingEntity = bangongwuziShenqingService.selectOne(queryWrapper);
        if(bangongwuziShenqingEntity==null){
            bangongwuziShenqing.setInsertTime(new Date());
            bangongwuziShenqing.setBangongwuziShenqingYesnoTypes(1);
            bangongwuziShenqing.setCreateTime(new Date());
            bangongwuziShenqingService.insert(bangongwuziShenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BangongwuziShenqingEntity bangongwuziShenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,bangongwuziShenqing:{}",this.getClass().getName(),bangongwuziShenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("教师".equals(role))
//            bangongwuziShenqing.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BangongwuziShenqingEntity> queryWrapper = new EntityWrapper<BangongwuziShenqingEntity>()
            .notIn("id",bangongwuziShenqing.getId())
            .andNew()
            .eq("jiaoshi_id", bangongwuziShenqing.getJiaoshiId())
            .eq("bangongwuzi_id", bangongwuziShenqing.getBangongwuziId())
            .eq("insert_time", bangongwuziShenqing.getInsertTime())
            .eq("bangongwuzi_shenqing_yesno_types", bangongwuziShenqing.getBangongwuziShenqingYesnoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BangongwuziShenqingEntity bangongwuziShenqingEntity = bangongwuziShenqingService.selectOne(queryWrapper);
        if(bangongwuziShenqingEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      bangongwuziShenqing.set
            //  }
            if(bangongwuziShenqing.getBangongwuziShenqingYesnoTypes() == 2){
                BangongwuziEntity bangongwuziEntity = new BangongwuziEntity();
                bangongwuziEntity.setJiaoshiId(bangongwuziShenqing.getJiaoshiId());
                bangongwuziEntity.setId(bangongwuziShenqing.getBangongwuziId());
                bangongwuziService.updateById(bangongwuziEntity);
            }
            bangongwuziShenqingService.updateById(bangongwuziShenqing);//根据id更新
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
        bangongwuziShenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<BangongwuziShenqingEntity> bangongwuziShenqingList = new ArrayList<>();//上传的东西
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
                            BangongwuziShenqingEntity bangongwuziShenqingEntity = new BangongwuziShenqingEntity();
//                            bangongwuziShenqingEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //申请教师 要改的
//                            bangongwuziShenqingEntity.setBangongwuziId(Integer.valueOf(data.get(0)));   //申请办公物资 要改的
//                            bangongwuziShenqingEntity.setInsertTime(date);//时间
//                            bangongwuziShenqingEntity.setBangongwuziShenqingYesnoTypes(Integer.valueOf(data.get(0)));   //申请结果 要改的
//                            bangongwuziShenqingEntity.setCreateTime(date);//时间
                            bangongwuziShenqingList.add(bangongwuziShenqingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        bangongwuziShenqingService.insertBatch(bangongwuziShenqingList);
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
        PageUtils page = bangongwuziShenqingService.queryPage(params);

        //字典表数据转换
        List<BangongwuziShenqingView> list =(List<BangongwuziShenqingView>)page.getList();
        for(BangongwuziShenqingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BangongwuziShenqingEntity bangongwuziShenqing = bangongwuziShenqingService.selectById(id);
            if(bangongwuziShenqing !=null){


                //entity转view
                BangongwuziShenqingView view = new BangongwuziShenqingView();
                BeanUtils.copyProperties( bangongwuziShenqing , view );//把实体数据重构到view中

                //级联表
                    BangongwuziEntity bangongwuzi = bangongwuziService.selectById(bangongwuziShenqing.getBangongwuziId());
                if(bangongwuzi != null){
                    BeanUtils.copyProperties( bangongwuzi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBangongwuziId(bangongwuzi.getId());
                }
                //级联表
                    JiaoshiEntity jiaoshi = jiaoshiService.selectById(bangongwuziShenqing.getJiaoshiId());
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
    public R add(@RequestBody BangongwuziShenqingEntity bangongwuziShenqing, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,bangongwuziShenqing:{}",this.getClass().getName(),bangongwuziShenqing.toString());
        Wrapper<BangongwuziShenqingEntity> queryWrapper = new EntityWrapper<BangongwuziShenqingEntity>()
            .eq("jiaoshi_id", bangongwuziShenqing.getJiaoshiId())
            .eq("bangongwuzi_id", bangongwuziShenqing.getBangongwuziId())
            .eq("bangongwuzi_shenqing_yesno_types", bangongwuziShenqing.getBangongwuziShenqingYesnoTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BangongwuziShenqingEntity bangongwuziShenqingEntity = bangongwuziShenqingService.selectOne(queryWrapper);
        if(bangongwuziShenqingEntity==null){
            bangongwuziShenqing.setInsertTime(new Date());
            bangongwuziShenqing.setBangongwuziShenqingYesnoTypes(1);
            bangongwuziShenqing.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      bangongwuziShenqing.set
        //  }
        bangongwuziShenqingService.insert(bangongwuziShenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
