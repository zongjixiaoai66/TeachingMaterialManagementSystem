package com.entity.vo;

import com.entity.BanjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 班级
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("banji")
public class BanjiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 院系
     */

    @TableField(value = "yuanxi_types")
    private Integer yuanxiTypes;


    /**
     * 班级名称
     */

    @TableField(value = "banji_name")
    private String banjiName;


    /**
     * 班级位置
     */

    @TableField(value = "banji_address")
    private String banjiAddress;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：院系
	 */
    public Integer getYuanxiTypes() {
        return yuanxiTypes;
    }


    /**
	 * 获取：院系
	 */

    public void setYuanxiTypes(Integer yuanxiTypes) {
        this.yuanxiTypes = yuanxiTypes;
    }
    /**
	 * 设置：班级名称
	 */
    public String getBanjiName() {
        return banjiName;
    }


    /**
	 * 获取：班级名称
	 */

    public void setBanjiName(String banjiName) {
        this.banjiName = banjiName;
    }
    /**
	 * 设置：班级位置
	 */
    public String getBanjiAddress() {
        return banjiAddress;
    }


    /**
	 * 获取：班级位置
	 */

    public void setBanjiAddress(String banjiAddress) {
        this.banjiAddress = banjiAddress;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
