package com.dao;

import com.entity.BangongwuziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BangongwuziView;

/**
 * 办公物资 Dao 接口
 *
 * @author 
 */
public interface BangongwuziDao extends BaseMapper<BangongwuziEntity> {

   List<BangongwuziView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
