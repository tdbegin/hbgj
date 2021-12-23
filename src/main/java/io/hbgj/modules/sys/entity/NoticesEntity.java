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
 * @date 2021-12-22 10:51:38
 */
@Data
@TableName("notices")
public class NoticesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 通知公告id
	 */
	@TableId
	private Integer id;
	/**
	 * 角色
	 */
	private String role;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 发布时间
	 */
	private String fbtime;
	/**
	 * 内容
	 */
	private String contents;
	/**
	 * 备着
	 */
	private String domainadd;

}
