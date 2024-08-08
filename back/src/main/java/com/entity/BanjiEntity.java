package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 班级
 *
 * @author 
 * @email
 */
@TableName("banji")
public class BanjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BanjiEntity() {

	}

	public BanjiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Banji{" +
            "id=" + id +
            ", yuanxiTypes=" + yuanxiTypes +
            ", banjiName=" + banjiName +
            ", banjiAddress=" + banjiAddress +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
