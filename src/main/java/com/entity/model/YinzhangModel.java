package com.entity.model;

import com.entity.YinzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 印章
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YinzhangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 印章编号
     */
    private String yinzhangUuidNumber;


    /**
     * 印章名称
     */
    private String yinzhangName;


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
	 * 获取：印章编号
	 */
    public String getYinzhangUuidNumber() {
        return yinzhangUuidNumber;
    }


    /**
	 * 设置：印章编号
	 */
    public void setYinzhangUuidNumber(String yinzhangUuidNumber) {
        this.yinzhangUuidNumber = yinzhangUuidNumber;
    }
    /**
	 * 获取：印章名称
	 */
    public String getYinzhangName() {
        return yinzhangName;
    }


    /**
	 * 设置：印章名称
	 */
    public void setYinzhangName(String yinzhangName) {
        this.yinzhangName = yinzhangName;
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
