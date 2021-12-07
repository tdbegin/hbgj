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
 * @date 2021-11-29 10:45:26
 */
@Data
@TableName("polintro")
public class PolintroEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 政策解读id
	 */
	@TableId
	private Integer newid;
	/**
	 * 标题
	 */
	private String newtitle;
	/**
	 * 时间
	 */
	private String newdate;
	/**
	 * 简介
	 */
	private String newabstract;
	/**
	 * 内容
	 */
	private String newdesc;
	/**
	 * 图片路径
	 */
	private String newimagepath;

}
