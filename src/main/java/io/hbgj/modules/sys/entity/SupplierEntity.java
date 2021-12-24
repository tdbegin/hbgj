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
 * @date 2021-12-24 14:38:11
 */
@Data
@TableName("supplier")
public class SupplierEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 供应商id
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
	 * 备着
	 */
	private String fallback;

}
