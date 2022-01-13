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
 * @date 2022-01-12 09:01:34
 */
@Data
@TableName("workflow")
public class WorkflowEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 流程id
	 */
	@TableId
	private Integer id;
	/**
	 * 流程
	 */
	private String flowpath;
	/**
	 * 项目名
	 */
	private String xmname;
	/**
	 * 时间
	 */
	private String times;
	/**
	 * 联系人
	 */
	private String linker;
	/**
	 * 备着
	 */
	private String fallback;

}
