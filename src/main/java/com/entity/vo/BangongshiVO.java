package com.entity.vo;

import com.entity.BangongshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 办公室
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bangongshi")
public class BangongshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
