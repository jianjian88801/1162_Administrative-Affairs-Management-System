package com.dao;

import com.entity.JiaoshiQingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoshiQingjiaView;

/**
 * 请假申请 Dao 接口
 *
 * @author 
 */
public interface JiaoshiQingjiaDao extends BaseMapper<JiaoshiQingjiaEntity> {

   List<JiaoshiQingjiaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
