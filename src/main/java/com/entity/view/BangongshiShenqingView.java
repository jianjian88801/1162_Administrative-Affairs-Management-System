package com.entity.view;

import com.entity.BangongshiShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 办公室申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bangongshi_shenqing")
public class BangongshiShenqingView extends BangongshiShenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请结果的值
		*/
		private String bangongshiShenqingYesnoValue;



		//级联表 bangongshi
			/**
			* 办公室房间号
			*/
			private String bangongshiName;
			/**
			* 详细地址
			*/
			private String bangongshiAddress;

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

	public BangongshiShenqingView() {

	}

	public BangongshiShenqingView(BangongshiShenqingEntity bangongshiShenqingEntity) {
		try {
			BeanUtils.copyProperties(this, bangongshiShenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 申请结果的值
			*/
			public String getBangongshiShenqingYesnoValue() {
				return bangongshiShenqingYesnoValue;
			}
			/**
			* 设置： 申请结果的值
			*/
			public void setBangongshiShenqingYesnoValue(String bangongshiShenqingYesnoValue) {
				this.bangongshiShenqingYesnoValue = bangongshiShenqingYesnoValue;
			}





				//级联表的get和set bangongshi
					/**
					* 获取： 办公室房间号
					*/
					public String getBangongshiName() {
						return bangongshiName;
					}
					/**
					* 设置： 办公室房间号
					*/
					public void setBangongshiName(String bangongshiName) {
						this.bangongshiName = bangongshiName;
					}
					/**
					* 获取： 详细地址
					*/
					public String getBangongshiAddress() {
						return bangongshiAddress;
					}
					/**
					* 设置： 详细地址
					*/
					public void setBangongshiAddress(String bangongshiAddress) {
						this.bangongshiAddress = bangongshiAddress;
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



















}
