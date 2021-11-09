/**
 * Copyright (c) 2016-2019  All rights reserved.
 *
 * https://www.hbgj.io
 *
 * 版权所有，侵权必究！
 */

package io.hbgj.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
