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
@TableName("qyregister")
public class QyregisterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long registerid;
	/**
	 * 企业名称
	 */
	private String qyname;
	/**
	 * 项目地址
	 */
	private String qyaddress;
	/**
	 * 是否环评：“1”是，“0”否
	 */
	private Integer hjappraise;
	/**
	 * 环评批复编号
	 */
	private String replynumber;
	/**
	 * 应急预案备案编号
	 */
	private String yjyabanumber;
	/**
	 * 排污许可证编号
	 */
	private String pwxkznumber;
	/**
	 * 排水许可证编号
	 */
	private String psxkzumber;
	/**
	 * 是否验收：“1”是，“0”否
	 */
	private Integer qycheck;
	/**
	 * 是否在线监测：“1”是，“0”否
	 */
	private Integer supervise;
	/**
	 * 固废处理情况：“1”是，“0”否
	 */
	private Integer result;
	/**
	 * 固废转移联单
	 */
	private String transfer;
	/**
	 * 环保行政处罚文件
	 */
	private String cffile;
	/**
	 * 排污口标志牌
	 */
	private String wrmarker;
	/**
	 * 清洁生产情况
	 */
	private String production;
	/**
	 * 环境友好型企业评选与企业环保形象、荣誉名称
	 */
	private String honour;
	/**
	 * 是否有专职环保管理人员：“1”是，“0”否
	 */
	private Integer enmanager;
	/**
	 * 环保管理人员名字
	 */
	private String enmanagername;
	/**
	 * 环保管理人员联系方式
	 */
	private String telphone;
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 角色
	 */
	private String role;
}
