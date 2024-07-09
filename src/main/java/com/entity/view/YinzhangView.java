package com.entity.view;

import com.entity.YinzhangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 印章
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yinzhang")
public class YinzhangView extends YinzhangEntity implements Serializable {
    private static final long serialVersionUID = 1L;




	public YinzhangView() {

	}

	public YinzhangView(YinzhangEntity yinzhangEntity) {
		try {
			BeanUtils.copyProperties(this, yinzhangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



















}
