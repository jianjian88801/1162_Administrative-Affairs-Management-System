package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BangongwuziShenqingEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 办公物资申请 服务类
 */
public interface BangongwuziShenqingService extends IService<BangongwuziShenqingEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}