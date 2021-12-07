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
@TableName("zjintro")
public class ZjintroEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 专家简介id
	 */
	@TableId
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 职称
	 */
	private String rank;
	/**
	 * 图片地址
	 */
	private String picaddress;
	/**
	 * 专家简介
	 */
	private String zjdesc;

}
