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
 * @date 2022-01-14 10:19:28
 */
@Data
@TableName("workflowson")
public class WorkflowsonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String xmname;
	/**
	 * 
	 */
	private String flowpath;
	/**
	 * 
	 */
	private String times;
	/**
	 * 
	 */
	private String linker;
	/**
	 * 
	 */
	private String fallback;

}
