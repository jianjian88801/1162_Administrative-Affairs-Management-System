package com.entity.view;

import com.entity.HuiyishiShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 会议室申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huiyishi_shenqing")
public class HuiyishiShenqingView extends HuiyishiShenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请结果的值
		*/
		private String huiyishiShenqingYesnoValue;



		//级联表 huiyishi
			/**
			* 会议室编号
			*/
			private String huiyishiUuidNumber;
			/**
			* 会议室地址
			*/
			private String huiyishiAddress;
			/**
			* 会议室大小
			*/
			private String huiyishiSize;
			/**
			* 会议室类型
			*/
			private Integer huiyishiTypes;
				/**
				* 会议室类型的值
				*/
				private String huiyishiValue;
			/**
			* 会议室状态
			*/
			private Integer zhuangtaiTypes;
				/**
				* 会议室状态的值
				*/
				private String zhuangtaiValue;

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

	public HuiyishiShenqingView() {

	}

	public HuiyishiShenqingView(HuiyishiShenqingEntity huiyishiShenqingEntity) {
		try {
			BeanUtils.copyProperties(this, huiyishiShenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 申请结果的值
			*/
			public String getHuiyishiShenqingYesnoValue() {
				return huiyishiShenqingYesnoValue;
			}
			/**
			* 设置： 申请结果的值
			*/
			public void setHuiyishiShenqingYesnoValue(String huiyishiShenqingYesnoValue) {
				this.huiyishiShenqingYesnoValue = huiyishiShenqingYesnoValue;
			}




















				//级联表的get和set huiyishi
					/**
					* 获取： 会议室编号
					*/
					public String getHuiyishiUuidNumber() {
						return huiyishiUuidNumber;
					}
					/**
					* 设置： 会议室编号
					*/
					public void setHuiyishiUuidNumber(String huiyishiUuidNumber) {
						this.huiyishiUuidNumber = huiyishiUuidNumber;
					}
					/**
					* 获取： 会议室地址
					*/
					public String getHuiyishiAddress() {
						return huiyishiAddress;
					}
					/**
					* 设置： 会议室地址
					*/
					public void setHuiyishiAddress(String huiyishiAddress) {
						this.huiyishiAddress = huiyishiAddress;
					}
					/**
					* 获取： 会议室大小
					*/
					public String getHuiyishiSize() {
						return huiyishiSize;
					}
					/**
					* 设置： 会议室大小
					*/
					public void setHuiyishiSize(String huiyishiSize) {
						this.huiyishiSize = huiyishiSize;
					}
					/**
					* 获取： 会议室类型
					*/
					public Integer getHuiyishiTypes() {
						return huiyishiTypes;
					}
					/**
					* 设置： 会议室类型
					*/
					public void setHuiyishiTypes(Integer huiyishiTypes) {
						this.huiyishiTypes = huiyishiTypes;
					}


						/**
						* 获取： 会议室类型的值
						*/
						public String getHuiyishiValue() {
							return huiyishiValue;
						}
						/**
						* 设置： 会议室类型的值
						*/
						public void setHuiyishiValue(String huiyishiValue) {
							this.huiyishiValue = huiyishiValue;
						}
					/**
					* 获取： 会议室状态
					*/
					public Integer getZhuangtaiTypes() {
						return zhuangtaiTypes;
					}
					/**
					* 设置： 会议室状态
					*/
					public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
						this.zhuangtaiTypes = zhuangtaiTypes;
					}


						/**
						* 获取： 会议室状态的值
						*/
						public String getZhuangtaiValue() {
							return zhuangtaiValue;
						}
						/**
						* 设置： 会议室状态的值
						*/
						public void setZhuangtaiValue(String zhuangtaiValue) {
							this.zhuangtaiValue = zhuangtaiValue;
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
