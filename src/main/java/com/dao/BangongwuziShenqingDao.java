package com.dao;

import com.entity.BangongwuziShenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BangongwuziShenqingView;

/**
 * 办公物资申请 Dao 接口
 *
 * @author 
 */
public interface BangongwuziShenqingDao extends BaseMapper<BangongwuziShenqingEntity> {

   List<BangongwuziShenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
