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
 * 请假申请
 *
 * @author 
 * @email
 */
@TableName("jiaoshi_qingjia")
public class JiaoshiQingjiaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaoshiQingjiaEntity() {

	}

	public JiaoshiQingjiaEntity(T t) {
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
     * 请假时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 请假结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qingjia_time")

    private Date qingjiaTime;


    /**
     * 审核结果
     */
    @TableField(value = "jiaoshi_qingjia_yesno_types")

    private Integer jiaoshiQingjiaYesnoTypes;


    /**
     * 请假原因
     */
    @TableField(value = "qingjia_content")

    private String qingjiaContent;


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
	 * 设置：请假时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：请假时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：请假结束时间
	 */
    public Date getQingjiaTime() {
        return qingjiaTime;
    }


    /**
	 * 获取：请假结束时间
	 */

    public void setQingjiaTime(Date qingjiaTime) {
        this.qingjiaTime = qingjiaTime;
    }
    /**
	 * 设置：审核结果
	 */
    public Integer getJiaoshiQingjiaYesnoTypes() {
        return jiaoshiQingjiaYesnoTypes;
    }


    /**
	 * 获取：审核结果
	 */

    public void setJiaoshiQingjiaYesnoTypes(Integer jiaoshiQingjiaYesnoTypes) {
        this.jiaoshiQingjiaYesnoTypes = jiaoshiQingjiaYesnoTypes;
    }
    /**
	 * 设置：请假原因
	 */
    public String getQingjiaContent() {
        return qingjiaContent;
    }


    /**
	 * 获取：请假原因
	 */

    public void setQingjiaContent(String qingjiaContent) {
        this.qingjiaContent = qingjiaContent;
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
        return "JiaoshiQingjia{" +
            "id=" + id +
            ", jiaoshiId=" + jiaoshiId +
            ", insertTime=" + insertTime +
            ", qingjiaTime=" + qingjiaTime +
            ", jiaoshiQingjiaYesnoTypes=" + jiaoshiQingjiaYesnoTypes +
            ", qingjiaContent=" + qingjiaContent +
            ", createTime=" + createTime +
        "}";
    }
}
