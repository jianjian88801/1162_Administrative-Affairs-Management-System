package com.entity.model;

import com.entity.JiaoshiLizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 离职申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaoshiLizhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请教师
     */
    private Integer jiaoshiId;


    /**
     * 离职申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 离职原因
     */
    private String lizhiContent;


    /**
     * 审核结果
     */
    private Integer jiaoshiLizhiYesnoTypes;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：申请教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：申请教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：离职申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：离职申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：离职原因
	 */
    public String getLizhiContent() {
        return lizhiContent;
    }


    /**
	 * 设置：离职原因
	 */
    public void setLizhiContent(String lizhiContent) {
        this.lizhiContent = lizhiContent;
    }
    /**
	 * 获取：审核结果
	 */
    public Integer getJiaoshiLizhiYesnoTypes() {
        return jiaoshiLizhiYesnoTypes;
    }


    /**
	 * 设置：审核结果
	 */
    public void setJiaoshiLizhiYesnoTypes(Integer jiaoshiLizhiYesnoTypes) {
        this.jiaoshiLizhiYesnoTypes = jiaoshiLizhiYesnoTypes;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
