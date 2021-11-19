package io.hbgj.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-11-17 09:40:46
 */
@Data
@TableName("qyfcqy")
public class QyfcqyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业风采（企业）id
	 */
	@TableId
	private Integer id;
	/**
	 * 企业名称
	 */
	private String qyname;
	/**
	 * 公司官网
	 */
	private String website;
	/**
	 * 简介
	 */
	private String introduction;
	/**
	 * 联系人
	 */
	private String linkname;
	/**
	 * 联系方式
	 */
	private String linkmumber;
	/**
	 * 备选
	 */
	private String fallback;

}
