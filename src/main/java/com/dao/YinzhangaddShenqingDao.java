package com.dao;

import com.entity.YinzhangaddShenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YinzhangaddShenqingView;

/**
 * 印章添加申请 Dao 接口
 *
 * @author 
 */
public interface YinzhangaddShenqingDao extends BaseMapper<YinzhangaddShenqingEntity> {

   List<YinzhangaddShenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
