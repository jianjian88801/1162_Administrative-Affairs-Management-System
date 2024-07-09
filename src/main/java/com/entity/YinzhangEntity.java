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
 * 印章
 *
 * @author 
 * @email
 */
@TableName("yinzhang")
public class YinzhangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YinzhangEntity() {

	}

	public YinzhangEntity(T t) {
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
     * 印章编号
     */
    @TableField(value = "yinzhang_uuid_number")

    private String yinzhangUuidNumber;


    /**
     * 印章名称
     */
    @TableField(value = "yinzhang_name")

    private String yinzhangName;


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
	 * 设置：印章编号
	 */
    public String getYinzhangUuidNumber() {
        return yinzhangUuidNumber;
    }


    /**
	 * 获取：印章编号
	 */

    public void setYinzhangUuidNumber(String yinzhangUuidNumber) {
        this.yinzhangUuidNumber = yinzhangUuidNumber;
    }
    /**
	 * 设置：印章名称
	 */
    public String getYinzhangName() {
        return yinzhangName;
    }


    /**
	 * 获取：印章名称
	 */

    public void setYinzhangName(String yinzhangName) {
        this.yinzhangName = yinzhangName;
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
        return "Yinzhang{" +
            "id=" + id +
            ", yinzhangUuidNumber=" + yinzhangUuidNumber +
            ", yinzhangName=" + yinzhangName +
            ", createTime=" + createTime +
        "}";
    }
}
