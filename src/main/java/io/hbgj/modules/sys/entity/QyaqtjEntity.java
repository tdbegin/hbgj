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
@TableName("qyaqtj")
public class QyaqtjEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业体检（安全体检）id
	 */
	@TableId
	private Integer id;
	/**
	 *企业名称
	 */
	private String qyname;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 安全生产责任制制定和落实情况，安全生产标准规范执行情况
	 */
	private String safetyzdls;
	/**
	 * 安全生产规章制度制定和执行情况
	 */
	private String safetyzdzx;
	/**
	 * 安全生产隐患排查治理情况
	 */
	private String safetyyhzl;
	/**
	 * 安全生产费用提取及使用情况
	 */
	private String safetyfysy;
	/**
	 * 安全生产教育培训情况
	 */
	private String safetyjypx;
	/**
	 * 安全生产应急救援情况
	 */
	private String safetyyjqy;
	/**
	 * 生产安全事故的报告和应急救援情况
	 */
	private String safetybgqk;
	/**
	 * 其它方面的情况
	 */
	private String others;
	/**
	 * 联系方式
	 */
	private String linknum;

}
