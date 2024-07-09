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
 * 印章添加申请
 *
 * @author 
 * @email
 */
@TableName("yinzhangadd_shenqing")
public class YinzhangaddShenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YinzhangaddShenqingEntity() {

	}

	public YinzhangaddShenqingEntity(T t) {
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
     * 印章名称
     */
    @TableField(value = "yinzhang_name")

    private String yinzhangName;


    /**
     * 材料
     */
    @TableField(value = "yinzhang_file")

    private String yinzhangFile;


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
    @TableField(value = "yinzhangadd_shenqing_yesno_types")

    private Integer yinzhangaddShenqingYesnoTypes;


    /**
     * 添加原因
     */
    @TableField(value = "yinzhang_shenqing_content")

    private String yinzhangShenqingContent;


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
	 * 设置：材料
	 */
    public String getYinzhangFile() {
        return yinzhangFile;
    }


    /**
	 * 获取：材料
	 */

    public void setYinzhangFile(String yinzhangFile) {
        this.yinzhangFile = yinzhangFile;
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
    public Integer getYinzhangaddShenqingYesnoTypes() {
        return yinzhangaddShenqingYesnoTypes;
    }


    /**
	 * 获取：申请结果
	 */

    public void setYinzhangaddShenqingYesnoTypes(Integer yinzhangaddShenqingYesnoTypes) {
        this.yinzhangaddShenqingYesnoTypes = yinzhangaddShenqingYesnoTypes;
    }
    /**
	 * 设置：添加原因
	 */
    public String getYinzhangShenqingContent() {
        return yinzhangShenqingContent;
    }


    /**
	 * 获取：添加原因
	 */

    public void setYinzhangShenqingContent(String yinzhangShenqingContent) {
        this.yinzhangShenqingContent = yinzhangShenqingContent;
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
        return "YinzhangaddShenqing{" +
            "id=" + id +
            ", jiaoshiId=" + jiaoshiId +
            ", yinzhangName=" + yinzhangName +
            ", yinzhangFile=" + yinzhangFile +
            ", insertTime=" + insertTime +
            ", yinzhangaddShenqingYesnoTypes=" + yinzhangaddShenqingYesnoTypes +
            ", yinzhangShenqingContent=" + yinzhangShenqingContent +
            ", createTime=" + createTime +
        "}";
    }
}
