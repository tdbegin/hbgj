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
 * @date 2021-11-26 09:47:44
 */
@Data
@TableName("bussniesswork")
public class BussniessworkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 业务直通车id
	 */
	@TableId
	private Integer id;
	/**
	 * 企业名称
	 */
	private String qyname;
	/**
	 * 联系人
	 */
	private String linkman;
	/**
	 * 号码
	 */
	private String linknum;
	/**
	 * 邮件
	 */
	private String emails;
	/**
	 * 委托项目
	 */
	private String project;
	/**
	 * 集采团购-委托项目需求说明
	 */
	private String exp;
	/**
	 * 集采团购招标-委托项目附件
	 */
	private String accessory;
	/**
	 * 历史委托单位
	 */
	private String hiscomm;
	/**
	 * 项目预算
	 */
	private String budget;
	/**
	 * 期望完成时间
	 */
	private String exptime;
	/**
	 * 备着
	 */
	private String fallback;

}
