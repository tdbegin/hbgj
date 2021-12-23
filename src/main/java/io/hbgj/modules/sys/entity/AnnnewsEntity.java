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
 * @date 2021-11-22 13:24:21
 */
@Data
@TableName("annnews")
public class AnnnewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer newid;
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
	private String firstname;


	private String domainadd;

}
