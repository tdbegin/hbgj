package io.hbgj.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-11-19 16:10:02
 */
@Data
@TableName("qyinfomation")
public class QyinfomationEntity implements Serializable {
	private static final long serialVersionUID = 1L;


    @TableId
	private Integer id;
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
	private Integer eninfopublic;
	/**
	 * 名称
	 */
	private String qyname;
	/**
	 * 法定代表人姓名
	 */
	private String legalper;
	/**
	 * 注册资本
	 */
	private String registeredcap;
	/**
	 * 公司类型
	 */
	private String companytype;
	/**
	 * 营业期限
	 */
	private String timelimit;
	/**
	 * 受理机关
	 */
	private String acceptjg;
	/**
	 * 经营范围
	 */
	private String businessscope;
	/**
	 * 统一社会信用码/注册号
	 */
	private String regnumber;
	/**
	 * 住所
	 */
	private String address;
	/**
	 * 企业状态
	 */
	private String qystate;
	/**
	 * 成立日期
	 */
	private String begindate;
	/**
	 * 登记机关
	 */
	private String markjg;
	/**
	 * 邓白氏编码
	 */
	private String dbsnumber;
	/**
	 * 主要污染物类别
	 */
	private String wrwlb;
	/**
	 * 大气主要污染物种类
	 */
	private String dqwrwzl;
	/**
	 * 大气污染物排放规律
	 */
	private String dqwrwgl;
	/**
	 * 大气污染物排放执行标准
	 */
	private String dawrwbz;
	/**
	 * 废水主要污染物种类
	 */
	private String fswrwzl;
	/**
	 * 废水污染物排放规律
	 */
	private String fswrwgl;
	/**
	 * 废水污染物排放执行标准
	 */
	private String fswrwbz;
	/**
	 * 排污权使用和交易信息
	 */
	private String tradeinfo;

}
