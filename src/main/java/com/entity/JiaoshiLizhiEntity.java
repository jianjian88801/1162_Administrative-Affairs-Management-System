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
 * 离职申请
 *
 * @author 
 * @email
 */
@TableName("jiaoshi_lizhi")
public class JiaoshiLizhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaoshiLizhiEntity() {

	}

	public JiaoshiLizhiEntity(T t) {
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
     * 离职申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 离职原因
     */
    @TableField(value = "lizhi_content")

    private String lizhiContent;


    /**
     * 审核结果
     */
    @TableField(value = "jiaoshi_lizhi_yesno_types")

    private Integer jiaoshiLizhiYesnoTypes;


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
	 * 设置：离职申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：离职申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：离职原因
	 */
    public String getLizhiContent() {
        return lizhiContent;
    }


    /**
	 * 获取：离职原因
	 */

    public void setLizhiContent(String lizhiContent) {
        this.lizhiContent = lizhiContent;
    }
    /**
	 * 设置：审核结果
	 */
    public Integer getJiaoshiLizhiYesnoTypes() {
        return jiaoshiLizhiYesnoTypes;
    }


    /**
	 * 获取：审核结果
	 */

    public void setJiaoshiLizhiYesnoTypes(Integer jiaoshiLizhiYesnoTypes) {
        this.jiaoshiLizhiYesnoTypes = jiaoshiLizhiYesnoTypes;
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
        return "JiaoshiLizhi{" +
            "id=" + id +
            ", jiaoshiId=" + jiaoshiId +
            ", insertTime=" + insertTime +
            ", lizhiContent=" + lizhiContent +
            ", jiaoshiLizhiYesnoTypes=" + jiaoshiLizhiYesnoTypes +
            ", createTime=" + createTime +
        "}";
    }
}
