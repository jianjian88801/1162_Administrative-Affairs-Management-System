package com.entity.vo;

import com.entity.YinzhangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 印章
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yinzhang")
public class YinzhangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
