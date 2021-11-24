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
 * @date 2021-11-23 13:35:43
 */
@Data
@TableName("filename")
public class FilenameEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 存贮位置
	 */
	private String filepath;
	/**
	 * 文件名
	 */
	private String filename;
	/**
	 * 时间
	 */
	private String time;
	/**
	 * 域名地址
	 */
	private String domainadd;

}
