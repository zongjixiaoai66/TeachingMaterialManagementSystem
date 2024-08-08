
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
 * 学生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuesheng")
public class XueshengController {
    private static final Logger logger = LoggerFactory.getLogger(XueshengController.class);

    @Autowired
    private XueshengService xueshengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private BanjiService banjiService;
    @Autowired
    private LaoshiService laoshiService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xueshengService.queryPage(params);

        //字典表数据转换
        List<XueshengView> list =(List<XueshengView>)page.getList();
        for(XueshengView c:list){
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
        XueshengEntity xuesheng = xueshengService.selectById(id);
        if(xuesheng !=null){
            //entity转view
            XueshengView view = new XueshengView();
            BeanUtils.copyProperties( xuesheng , view );//把实体数据重构到view中

                //级联表
                BanjiEntity banji = banjiService.selectById(xuesheng.getBanjiId());
                if(banji != null){
                    BeanUtils.copyProperties( banji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBanjiId(banji.getId());
                }
                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(xuesheng.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
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
    public R save(@RequestBody XueshengEntity xuesheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuesheng:{}",this.getClass().getName(),xuesheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            xuesheng.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XueshengEntity> queryWrapper = new EntityWrapper<XueshengEntity>()
            .eq("laoshi_id", xuesheng.getLaoshiId())
            .eq("banji_id", xuesheng.getBanjiId())
            .eq("xuesheng_name", xuesheng.getXueshengName())
            .eq("xuesheng_phone", xuesheng.getXueshengPhone())
            .eq("xuesheng_id_number", xuesheng.getXueshengIdNumber())
            .eq("xuesheng_email", xuesheng.getXueshengEmail())
            .eq("sex_types", xuesheng.getSexTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengEntity xueshengEntity = xueshengService.selectOne(queryWrapper);
        if(xueshengEntity==null){
            xuesheng.setInsertTime(new Date());
            xuesheng.setCreateTime(new Date());
            xueshengService.insert(xuesheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XueshengEntity xuesheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xuesheng:{}",this.getClass().getName(),xuesheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            xuesheng.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XueshengEntity> queryWrapper = new EntityWrapper<XueshengEntity>()
            .notIn("id",xuesheng.getId())
            .andNew()
            .eq("laoshi_id", xuesheng.getLaoshiId())
            .eq("banji_id", xuesheng.getBanjiId())
            .eq("xuesheng_name", xuesheng.getXueshengName())
            .eq("xuesheng_phone", xuesheng.getXueshengPhone())
            .eq("xuesheng_id_number", xuesheng.getXueshengIdNumber())
            .eq("xuesheng_email", xuesheng.getXueshengEmail())
            .eq("sex_types", xuesheng.getSexTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XueshengEntity xueshengEntity = xueshengService.selectOne(queryWrapper);
        if("".equals(xuesheng.getXueshengPhoto()) || "null".equals(xuesheng.getXueshengPhoto())){
                xuesheng.setXueshengPhoto(null);
        }
        if(xueshengEntity==null){
            xueshengService.updateById(xuesheng);//根据id更新
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
        xueshengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<XueshengEntity> xueshengList = new ArrayList<>();//上传的东西
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
                            XueshengEntity xueshengEntity = new XueshengEntity();
//                            xueshengEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            xueshengEntity.setBanjiId(Integer.valueOf(data.get(0)));   //班级 要改的
//                            xueshengEntity.setXueshengName(data.get(0));                    //学生姓名 要改的
//                            xueshengEntity.setXueshengPhone(data.get(0));                    //学生手机号 要改的
//                            xueshengEntity.setXueshengIdNumber(data.get(0));                    //学生身份证号 要改的
//                            xueshengEntity.setXueshengPhoto("");//照片
//                            xueshengEntity.setXueshengEmail(data.get(0));                    //电子邮箱 要改的
//                            xueshengEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xueshengEntity.setXueshengContent("");//照片
//                            xueshengEntity.setInsertTime(date);//时间
//                            xueshengEntity.setCreateTime(date);//时间
                            xueshengList.add(xueshengEntity);


                            //把要查询是否重复的字段放入map中
                                //学生手机号
                                if(seachFields.containsKey("xueshengPhone")){
                                    List<String> xueshengPhone = seachFields.get("xueshengPhone");
                                    xueshengPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xueshengPhone = new ArrayList<>();
                                    xueshengPhone.add(data.get(0));//要改的
                                    seachFields.put("xueshengPhone",xueshengPhone);
                                }
                                //学生身份证号
                                if(seachFields.containsKey("xueshengIdNumber")){
                                    List<String> xueshengIdNumber = seachFields.get("xueshengIdNumber");
                                    xueshengIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xueshengIdNumber = new ArrayList<>();
                                    xueshengIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xueshengIdNumber",xueshengIdNumber);
                                }
                        }

                        //查询是否重复
                         //学生手机号
                        List<XueshengEntity> xueshengEntities_xueshengPhone = xueshengService.selectList(new EntityWrapper<XueshengEntity>().in("xuesheng_phone", seachFields.get("xueshengPhone")));
                        if(xueshengEntities_xueshengPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueshengEntity s:xueshengEntities_xueshengPhone){
                                repeatFields.add(s.getXueshengPhone());
                            }
                            return R.error(511,"数据库的该表中的 [学生手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //学生身份证号
                        List<XueshengEntity> xueshengEntities_xueshengIdNumber = xueshengService.selectList(new EntityWrapper<XueshengEntity>().in("xuesheng_id_number", seachFields.get("xueshengIdNumber")));
                        if(xueshengEntities_xueshengIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XueshengEntity s:xueshengEntities_xueshengIdNumber){
                                repeatFields.add(s.getXueshengIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [学生身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xueshengService.insertBatch(xueshengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
