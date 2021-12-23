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
@TableName("legislations")
public class LegislationsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 法律法规id
	 */
	@TableId
	private Integer id;
	/**
	 * 根据区域
	 */
	private String zone;
	/**
	 * 上传时间
	 */private String title;
	/**
	 * 上传时间
	 */
	private String uploadtime;
	/**
	 * 内容
	 */
	private String content;

	/**
	 * 文件路径
	 */
	private String domainadd;




}
