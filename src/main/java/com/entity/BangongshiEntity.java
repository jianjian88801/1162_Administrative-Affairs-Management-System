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
 * 办公室
 *
 * @author 
 * @email
 */
@TableName("bangongshi")
public class BangongshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BangongshiEntity() {

	}

	public BangongshiEntity(T t) {
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
     * 办公室房间号
     */
    @TableField(value = "bangongshi_name")

    private String bangongshiName;


    /**
     * 详细地址
     */
    @TableField(value = "bangongshi_address")

    private String bangongshiAddress;


    /**
     * 使用教师
     */
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


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
	 * 设置：办公室房间号
	 */
    public String getBangongshiName() {
        return bangongshiName;
    }


    /**
	 * 获取：办公室房间号
	 */

    public void setBangongshiName(String bangongshiName) {
        this.bangongshiName = bangongshiName;
    }
    /**
	 * 设置：详细地址
	 */
    public String getBangongshiAddress() {
        return bangongshiAddress;
    }


    /**
	 * 获取：详细地址
	 */

    public void setBangongshiAddress(String bangongshiAddress) {
        this.bangongshiAddress = bangongshiAddress;
    }
    /**
	 * 设置：使用教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：使用教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
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
        return "Bangongshi{" +
            "id=" + id +
            ", bangongshiName=" + bangongshiName +
            ", bangongshiAddress=" + bangongshiAddress +
            ", jiaoshiId=" + jiaoshiId +
            ", createTime=" + createTime +
        "}";
    }
}
