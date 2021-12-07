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
 * @date 2021-11-22 13:24:22
 */
@Data
@TableName("announce")
public class AnnounceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 公告id
	 */
	@TableId
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 其它
	 */
	private String other;

}
