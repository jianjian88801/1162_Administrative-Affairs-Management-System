




















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
 * 办公物资
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bangongwuzi")
public class BangongwuziController {
    private static final Logger logger = LoggerFactory.getLogger(BangongwuziController.class);

    @Autowired
    private BangongwuziService bangongwuziService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
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
        PageUtils page = bangongwuziService.queryPage(params);

        //字典表数据转换
        List<BangongwuziView> list =(List<BangongwuziView>)page.getList();
        for(BangongwuziView c:list){
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
        BangongwuziEntity bangongwuzi = bangongwuziService.selectById(id);
        if(bangongwuzi !=null){
            //entity转view
            BangongwuziView view = new BangongwuziView();
            BeanUtils.copyProperties( bangongwuzi , view );//把实体数据重构到view中

                //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(bangongwuzi.getJiaoshiId());
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
    public R save(@RequestBody BangongwuziEntity bangongwuzi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bangongwuzi:{}",this.getClass().getName(),bangongwuzi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("教师".equals(role))
            bangongwuzi.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BangongwuziEntity> queryWrapper = new EntityWrapper<BangongwuziEntity>()
            .eq("bangongwuzi_uuid_number", bangongwuzi.getBangongwuziUuidNumber())
            .eq("bangongwuzi_name", bangongwuzi.getBangongwuziName())
            .eq("bangongwuzi_types", bangongwuzi.getBangongwuziTypes())
            .eq("jiaoshi_id", bangongwuzi.getJiaoshiId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BangongwuziEntity bangongwuziEntity = bangongwuziService.selectOne(queryWrapper);
        if(bangongwuziEntity==null){
            bangongwuzi.setCreateTime(new Date());
            bangongwuziService.insert(bangongwuzi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BangongwuziEntity bangongwuzi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,bangongwuzi:{}",this.getClass().getName(),bangongwuzi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("教师".equals(role))
//            bangongwuzi.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BangongwuziEntity> queryWrapper = new EntityWrapper<BangongwuziEntity>()
            .notIn("id",bangongwuzi.getId())
            .andNew()
            .eq("bangongwuzi_uuid_number", bangongwuzi.getBangongwuziUuidNumber())
            .eq("bangongwuzi_name", bangongwuzi.getBangongwuziName())
            .eq("bangongwuzi_types", bangongwuzi.getBangongwuziTypes())
            .eq("jiaoshi_id", bangongwuzi.getJiaoshiId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BangongwuziEntity bangongwuziEntity = bangongwuziService.selectOne(queryWrapper);
        if(bangongwuziEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      bangongwuzi.set
            //  }
            bangongwuziService.updateAllColumnById(bangongwuzi);//根据id更新
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
        bangongwuziService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<BangongwuziEntity> bangongwuziList = new ArrayList<>();//上传的东西
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
                            BangongwuziEntity bangongwuziEntity = new BangongwuziEntity();
//                            bangongwuziEntity.setBangongwuziUuidNumber(data.get(0));                    //物资编号 要改的
//                            bangongwuziEntity.setBangongwuziName(data.get(0));                    //物资名称 要改的
//                            bangongwuziEntity.setBangongwuziTypes(Integer.valueOf(data.get(0)));   //物资类型 要改的
//                            bangongwuziEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //使用教师 要改的
//                            bangongwuziEntity.setCreateTime(date);//时间
                            bangongwuziList.add(bangongwuziEntity);


                            //把要查询是否重复的字段放入map中
                                //物资编号
                                if(seachFields.containsKey("bangongwuziUuidNumber")){
                                    List<String> bangongwuziUuidNumber = seachFields.get("bangongwuziUuidNumber");
                                    bangongwuziUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> bangongwuziUuidNumber = new ArrayList<>();
                                    bangongwuziUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("bangongwuziUuidNumber",bangongwuziUuidNumber);
                                }
                        }

                        //查询是否重复
                         //物资编号
                        List<BangongwuziEntity> bangongwuziEntities_bangongwuziUuidNumber = bangongwuziService.selectList(new EntityWrapper<BangongwuziEntity>().in("bangongwuzi_uuid_number", seachFields.get("bangongwuziUuidNumber")));
                        if(bangongwuziEntities_bangongwuziUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BangongwuziEntity s:bangongwuziEntities_bangongwuziUuidNumber){
                                repeatFields.add(s.getBangongwuziUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [物资编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        bangongwuziService.insertBatch(bangongwuziList);
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
        PageUtils page = bangongwuziService.queryPage(params);

        //字典表数据转换
        List<BangongwuziView> list =(List<BangongwuziView>)page.getList();
        for(BangongwuziView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BangongwuziEntity bangongwuzi = bangongwuziService.selectById(id);
            if(bangongwuzi !=null){


                //entity转view
                BangongwuziView view = new BangongwuziView();
                BeanUtils.copyProperties( bangongwuzi , view );//把实体数据重构到view中

                //级联表
                    JiaoshiEntity jiaoshi = jiaoshiService.selectById(bangongwuzi.getJiaoshiId());
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
    public R add(@RequestBody BangongwuziEntity bangongwuzi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,bangongwuzi:{}",this.getClass().getName(),bangongwuzi.toString());
        Wrapper<BangongwuziEntity> queryWrapper = new EntityWrapper<BangongwuziEntity>()
            .eq("bangongwuzi_uuid_number", bangongwuzi.getBangongwuziUuidNumber())
            .eq("bangongwuzi_name", bangongwuzi.getBangongwuziName())
            .eq("bangongwuzi_types", bangongwuzi.getBangongwuziTypes())
            .eq("jiaoshi_id", bangongwuzi.getJiaoshiId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BangongwuziEntity bangongwuziEntity = bangongwuziService.selectOne(queryWrapper);
        if(bangongwuziEntity==null){
            bangongwuzi.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      bangongwuzi.set
        //  }
        bangongwuziService.insert(bangongwuzi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
