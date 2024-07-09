package com.dao;

import com.entity.HuiyishiShenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuiyishiShenqingView;

/**
 * 会议室申请 Dao 接口
 *
 * @author 
 */
public interface HuiyishiShenqingDao extends BaseMapper<HuiyishiShenqingEntity> {

   List<HuiyishiShenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
