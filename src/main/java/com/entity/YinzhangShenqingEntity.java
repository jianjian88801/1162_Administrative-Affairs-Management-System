package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 印章申请
 *
 * @author 
 * @email
 */
@TableName("yinzhang_shenqing")
public class YinzhangShenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YinzhangShenqingEntity() {

	}

	public YinzhangShenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 申请教师
     */
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 申请办公物资
     */
    @TableField(value = "yinzhang_id")

    private Integer yinzhangId;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请结果
     */
    @TableField(value = "yinzhang_shenqing_yesno_types")

    private Integer yinzhangShenqingYesnoTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：申请教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：申请教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：申请办公物资
	 */
    public Integer getYinzhangId() {
        return yinzhangId;
    }


    /**
	 * 获取：申请办公物资
	 */

    public void setYinzhangId(Integer yinzhangId) {
        this.yinzhangId = yinzhangId;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请结果
	 */
    public Integer getYinzhangShenqingYesnoTypes() {
        return yinzhangShenqingYesnoTypes;
    }


    /**
	 * 获取：申请结果
	 */

    public void setYinzhangShenqingYesnoTypes(Integer yinzhangShenqingYesnoTypes) {
        this.yinzhangShenqingYesnoTypes = yinzhangShenqingYesnoTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YinzhangShenqing{" +
            "id=" + id +
            ", jiaoshiId=" + jiaoshiId +
            ", yinzhangId=" + yinzhangId +
            ", insertTime=" + insertTime +
            ", yinzhangShenqingYesnoTypes=" + yinzhangShenqingYesnoTypes +
            ", createTime=" + createTime +
        "}";
    }
}
