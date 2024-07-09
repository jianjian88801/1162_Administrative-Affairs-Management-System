package com.entity.vo;

import com.entity.JiaoshiLizhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 离职申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaoshi_lizhi")
public class JiaoshiLizhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 申请教师
     */

    @TableField(value = "jiaoshi_id")
    private Integer jiaoshiId;


    /**
     * 离职申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 离职原因
     */

    @TableField(value = "lizhi_content")
    private String lizhiContent;


    /**
     * 审核结果
     */

    @TableField(value = "jiaoshi_lizhi_yesno_types")
    private Integer jiaoshiLizhiYesnoTypes;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：离职申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：离职申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：离职原因
	 */
    public String getLizhiContent() {
        return lizhiContent;
    }


    /**
	 * 获取：离职原因
	 */

    public void setLizhiContent(String lizhiContent) {
        this.lizhiContent = lizhiContent;
    }
    /**
	 * 设置：审核结果
	 */
    public Integer getJiaoshiLizhiYesnoTypes() {
        return jiaoshiLizhiYesnoTypes;
    }


    /**
	 * 获取：审核结果
	 */

    public void setJiaoshiLizhiYesnoTypes(Integer jiaoshiLizhiYesnoTypes) {
        this.jiaoshiLizhiYesnoTypes = jiaoshiLizhiYesnoTypes;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
