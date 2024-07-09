package com.dao;

import com.entity.YinzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YinzhangView;

/**
 * 印章 Dao 接口
 *
 * @author 
 */
public interface YinzhangDao extends BaseMapper<YinzhangEntity> {

   List<YinzhangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
