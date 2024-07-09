package com.entity.model;

import com.entity.BangongwuziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 办公物资
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BangongwuziModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 物资编号
     */
    private String bangongwuziUuidNumber;


    /**
     * 物资名称
     */
    private String bangongwuziName;


    /**
     * 物资类型
     */
    private Integer bangongwuziTypes;


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
	 * 获取：物资编号
	 */
    public String getBangongwuziUuidNumber() {
        return bangongwuziUuidNumber;
    }


    /**
	 * 设置：物资编号
	 */
    public void setBangongwuziUuidNumber(String bangongwuziUuidNumber) {
        this.bangongwuziUuidNumber = bangongwuziUuidNumber;
    }
    /**
	 * 获取：物资名称
	 */
    public String getBangongwuziName() {
        return bangongwuziName;
    }


    /**
	 * 设置：物资名称
	 */
    public void setBangongwuziName(String bangongwuziName) {
        this.bangongwuziName = bangongwuziName;
    }
    /**
	 * 获取：物资类型
	 */
    public Integer getBangongwuziTypes() {
        return bangongwuziTypes;
    }


    /**
	 * 设置：物资类型
	 */
    public void setBangongwuziTypes(Integer bangongwuziTypes) {
        this.bangongwuziTypes = bangongwuziTypes;
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
