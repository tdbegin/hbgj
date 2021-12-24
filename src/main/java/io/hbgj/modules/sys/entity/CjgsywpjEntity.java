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
 * @date 2021-12-24 16:21:57
 */
@Data
@TableName("cjgsywpj")
public class CjgsywpjEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 成交公示，业务评价id
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String parentname;
	/**
	 * 
	 */
	private String newtitle;
	/**
	 * 
	 */
	private String newdate;
	/**
	 * 
	 */
	private String newabstract;
	/**
	 * 
	 */
	private String newdesc;
	/**
	 * 
	 */
	private String domainadd;

}
