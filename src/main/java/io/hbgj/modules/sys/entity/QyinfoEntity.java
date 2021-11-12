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
 * @date 2021-11-11 14:19:06
 */
@Data
@TableName("qyinfo")
public class QyinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 编号
	 */
	@TableId
	private Integer id;
	/**
	 * 企业名称
	 */
	private String qyname;
	/**
	 * 上市
	 */
	private String qyipo;
	/**
	 * 环境信用
	 */
	private String encredit;
	/**
	 * 认证信息
	 */
	private String authinfo;
	/**
	 * 环境信息公开透明度
	 */
	private String eninfopublic;


}
