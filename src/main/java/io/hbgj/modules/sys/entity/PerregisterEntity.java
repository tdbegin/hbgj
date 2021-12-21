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
 * @date 2021-11-11 10:09:33
 */
@Data
@TableName("perregister")
public class PerregisterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 个人名字
	 */
	private String name;
	/**
	 * 联系电话
	 */
	private String telphone;
	/**
	 * 拟建项目名称
	 */
	private String xmname;
	/**
	 * 拟建项目地址
	 */
	private String xmaddress;
	/**
	 * 生产产品
	 */
	private String product;
	/**
	 * 是否备案：“1”是，“0”否
	 */
	private Integer reference;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 角色
	 */
	private String role;
}
