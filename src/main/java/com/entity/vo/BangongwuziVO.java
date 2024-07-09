package com.entity.vo;

import com.entity.BangongwuziEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 办公物资
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bangongwuzi")
public class BangongwuziVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
