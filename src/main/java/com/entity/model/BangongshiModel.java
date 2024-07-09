package com.entity.model;

import com.entity.BangongshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 办公室
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BangongshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 办公室房间号
     */
    private String bangongshiName;


    /**
     * 详细地址
     */
    private String bangongshiAddress;


    /**
     * 使用教师
     */
    private Integer jiaoshiId;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：办公室房间号
	 */
    public String getBangongshiName() {
        return bangongshiName;
    }


    /**
	 * 设置：办公室房间号
	 */
    public void setBangongshiName(String bangongshiName) {
        this.bangongshiName = bangongshiName;
    }
    /**
	 * 获取：详细地址
	 */
    public String getBangongshiAddress() {
        return bangongshiAddress;
    }


    /**
	 * 设置：详细地址
	 */
    public void setBangongshiAddress(String bangongshiAddress) {
        this.bangongshiAddress = bangongshiAddress;
    }
    /**
	 * 获取：使用教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：使用教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
