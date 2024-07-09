package com.entity.view;

import com.entity.YinzhangShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 印章申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yinzhang_shenqing")
public class YinzhangShenqingView extends YinzhangShenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请结果的值
		*/
		private String yinzhangShenqingYesnoValue;



		//级联表 jiaoshi
			/**
			* 教师姓名
			*/
			private String jiaoshiName;
			/**
			* 身份证号
			*/
			private String jiaoshiIdNumber;
			/**
			* 手机号
			*/
			private String jiaoshiPhone;
			/**
			* 照片
			*/
			private String jiaoshiPhoto;
			/**
			* 假删
			*/
			private Integer jiaoshiDelete;

		//级联表 yinzhang
			/**
			* 印章编号
			*/
			private String yinzhangUuidNumber;
			/**
			* 印章名称
			*/
			private String yinzhangName;

	public YinzhangShenqingView() {

	}

	public YinzhangShenqingView(YinzhangShenqingEntity yinzhangShenqingEntity) {
		try {
			BeanUtils.copyProperties(this, yinzhangShenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 申请结果的值
			*/
			public String getYinzhangShenqingYesnoValue() {
				return yinzhangShenqingYesnoValue;
			}
			/**
			* 设置： 申请结果的值
			*/
			public void setYinzhangShenqingYesnoValue(String yinzhangShenqingYesnoValue) {
				this.yinzhangShenqingYesnoValue = yinzhangShenqingYesnoValue;
			}

























				//级联表的get和set jiaoshi
					/**
					* 获取： 教师姓名
					*/
					public String getJiaoshiName() {
						return jiaoshiName;
					}
					/**
					* 设置： 教师姓名
					*/
					public void setJiaoshiName(String jiaoshiName) {
						this.jiaoshiName = jiaoshiName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getJiaoshiIdNumber() {
						return jiaoshiIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setJiaoshiIdNumber(String jiaoshiIdNumber) {
						this.jiaoshiIdNumber = jiaoshiIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getJiaoshiPhone() {
						return jiaoshiPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setJiaoshiPhone(String jiaoshiPhone) {
						this.jiaoshiPhone = jiaoshiPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getJiaoshiPhoto() {
						return jiaoshiPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setJiaoshiPhoto(String jiaoshiPhoto) {
						this.jiaoshiPhoto = jiaoshiPhoto;
					}
					/**
					* 获取： 假删
					*/
					public Integer getJiaoshiDelete() {
						return jiaoshiDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setJiaoshiDelete(Integer jiaoshiDelete) {
						this.jiaoshiDelete = jiaoshiDelete;
					}










				//级联表的get和set yinzhang
					/**
					* 获取： 印章编号
					*/
					public String getYinzhangUuidNumber() {
						return yinzhangUuidNumber;
					}
					/**
					* 设置： 印章编号
					*/
					public void setYinzhangUuidNumber(String yinzhangUuidNumber) {
						this.yinzhangUuidNumber = yinzhangUuidNumber;
					}
					/**
					* 获取： 印章名称
					*/
					public String getYinzhangName() {
						return yinzhangName;
					}
					/**
					* 设置： 印章名称
					*/
					public void setYinzhangName(String yinzhangName) {
						this.yinzhangName = yinzhangName;
					}









}
