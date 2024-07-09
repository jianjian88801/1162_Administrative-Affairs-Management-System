package com.entity.model;

import com.entity.YinzhangaddShenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 印章添加申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YinzhangaddShenqingModel implements Serializable {
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
     * 印章名称
     */
    private String yinzhangName;


    /**
     * 材料
     */
    private String yinzhangFile;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请结果
     */
    private Integer yinzhangaddShenqingYesnoTypes;


    /**
     * 添加原因
     */
    private String yinzhangShenqingContent;


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
	 * 获取：材料
	 */
    public String getYinzhangFile() {
        return yinzhangFile;
    }


    /**
	 * 设置：材料
	 */
    public void setYinzhangFile(String yinzhangFile) {
        this.yinzhangFile = yinzhangFile;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请结果
	 */
    public Integer getYinzhangaddShenqingYesnoTypes() {
        return yinzhangaddShenqingYesnoTypes;
    }


    /**
	 * 设置：申请结果
	 */
    public void setYinzhangaddShenqingYesnoTypes(Integer yinzhangaddShenqingYesnoTypes) {
        this.yinzhangaddShenqingYesnoTypes = yinzhangaddShenqingYesnoTypes;
    }
    /**
	 * 获取：添加原因
	 */
    public String getYinzhangShenqingContent() {
        return yinzhangShenqingContent;
    }


    /**
	 * 设置：添加原因
	 */
    public void setYinzhangShenqingContent(String yinzhangShenqingContent) {
        this.yinzhangShenqingContent = yinzhangShenqingContent;
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
