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
 * 办公物资
 *
 * @author 
 * @email
 */
@TableName("bangongwuzi")
public class BangongwuziEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BangongwuziEntity() {

	}

	public BangongwuziEntity(T t) {
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
     * 物资编号
     */
    @TableField(value = "bangongwuzi_uuid_number")

    private String bangongwuziUuidNumber;


    /**
     * 物资名称
     */
    @TableField(value = "bangongwuzi_name")

    private String bangongwuziName;


    /**
     * 物资类型
     */
    @TableField(value = "bangongwuzi_types")

    private Integer bangongwuziTypes;


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
	 * 设置：物资编号
	 */
    public String getBangongwuziUuidNumber() {
        return bangongwuziUuidNumber;
    }


    /**
	 * 获取：物资编号
	 */

    public void setBangongwuziUuidNumber(String bangongwuziUuidNumber) {
        this.bangongwuziUuidNumber = bangongwuziUuidNumber;
    }
    /**
	 * 设置：物资名称
	 */
    public String getBangongwuziName() {
        return bangongwuziName;
    }


    /**
	 * 获取：物资名称
	 */

    public void setBangongwuziName(String bangongwuziName) {
        this.bangongwuziName = bangongwuziName;
    }
    /**
	 * 设置：物资类型
	 */
    public Integer getBangongwuziTypes() {
        return bangongwuziTypes;
    }


    /**
	 * 获取：物资类型
	 */

    public void setBangongwuziTypes(Integer bangongwuziTypes) {
        this.bangongwuziTypes = bangongwuziTypes;
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
        return "Bangongwuzi{" +
            "id=" + id +
            ", bangongwuziUuidNumber=" + bangongwuziUuidNumber +
            ", bangongwuziName=" + bangongwuziName +
            ", bangongwuziTypes=" + bangongwuziTypes +
            ", jiaoshiId=" + jiaoshiId +
            ", createTime=" + createTime +
        "}";
    }
}
