package com.entity.model;

import com.entity.HuiyishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 会议室
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuiyishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 会议室编号
     */
    private String huiyishiUuidNumber;


    /**
     * 会议室地址
     */
    private String huiyishiAddress;


    /**
     * 会议室大小
     */
    private String huiyishiSize;


    /**
     * 会议室类型
     */
    private Integer huiyishiTypes;


    /**
     * 会议室状态
     */
    private Integer zhuangtaiTypes;


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
	 * 获取：会议室编号
	 */
    public String getHuiyishiUuidNumber() {
        return huiyishiUuidNumber;
    }


    /**
	 * 设置：会议室编号
	 */
    public void setHuiyishiUuidNumber(String huiyishiUuidNumber) {
        this.huiyishiUuidNumber = huiyishiUuidNumber;
    }
    /**
	 * 获取：会议室地址
	 */
    public String getHuiyishiAddress() {
        return huiyishiAddress;
    }


    /**
	 * 设置：会议室地址
	 */
    public void setHuiyishiAddress(String huiyishiAddress) {
        this.huiyishiAddress = huiyishiAddress;
    }
    /**
	 * 获取：会议室大小
	 */
    public String getHuiyishiSize() {
        return huiyishiSize;
    }


    /**
	 * 设置：会议室大小
	 */
    public void setHuiyishiSize(String huiyishiSize) {
        this.huiyishiSize = huiyishiSize;
    }
    /**
	 * 获取：会议室类型
	 */
    public Integer getHuiyishiTypes() {
        return huiyishiTypes;
    }


    /**
	 * 设置：会议室类型
	 */
    public void setHuiyishiTypes(Integer huiyishiTypes) {
        this.huiyishiTypes = huiyishiTypes;
    }
    /**
	 * 获取：会议室状态
	 */
    public Integer getZhuangtaiTypes() {
        return zhuangtaiTypes;
    }


    /**
	 * 设置：会议室状态
	 */
    public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
        this.zhuangtaiTypes = zhuangtaiTypes;
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
