package com.entity.view;

import com.entity.BangongwuziShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 办公物资申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bangongwuzi_shenqing")
public class BangongwuziShenqingView extends BangongwuziShenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请结果的值
		*/
		private String bangongwuziShenqingYesnoValue;



		//级联表 bangongwuzi
			/**
			* 物资编号
			*/
			private String bangongwuziUuidNumber;
			/**
			* 物资名称
			*/
			private String bangongwuziName;
			/**
			* 物资类型
			*/
			private Integer bangongwuziTypes;
				/**
				* 物资类型的值
				*/
				private String bangongwuziValue;

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

	public BangongwuziShenqingView() {

	}

	public BangongwuziShenqingView(BangongwuziShenqingEntity bangongwuziShenqingEntity) {
		try {
			BeanUtils.copyProperties(this, bangongwuziShenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 申请结果的值
			*/
			public String getBangongwuziShenqingYesnoValue() {
				return bangongwuziShenqingYesnoValue;
			}
			/**
			* 设置： 申请结果的值
			*/
			public void setBangongwuziShenqingYesnoValue(String bangongwuziShenqingYesnoValue) {
				this.bangongwuziShenqingYesnoValue = bangongwuziShenqingYesnoValue;
			}











				//级联表的get和set bangongwuzi
					/**
					* 获取： 物资编号
					*/
					public String getBangongwuziUuidNumber() {
						return bangongwuziUuidNumber;
					}
					/**
					* 设置： 物资编号
					*/
					public void setBangongwuziUuidNumber(String bangongwuziUuidNumber) {
						this.bangongwuziUuidNumber = bangongwuziUuidNumber;
					}
					/**
					* 获取： 物资名称
					*/
					public String getBangongwuziName() {
						return bangongwuziName;
					}
					/**
					* 设置： 物资名称
					*/
					public void setBangongwuziName(String bangongwuziName) {
						this.bangongwuziName = bangongwuziName;
					}
					/**
					* 获取： 物资类型
					*/
					public Integer getBangongwuziTypes() {
						return bangongwuziTypes;
					}
					/**
					* 设置： 物资类型
					*/
					public void setBangongwuziTypes(Integer bangongwuziTypes) {
						this.bangongwuziTypes = bangongwuziTypes;
					}


						/**
						* 获取： 物资类型的值
						*/
						public String getBangongwuziValue() {
							return bangongwuziValue;
						}
						/**
						* 设置： 物资类型的值
						*/
						public void setBangongwuziValue(String bangongwuziValue) {
							this.bangongwuziValue = bangongwuziValue;
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
