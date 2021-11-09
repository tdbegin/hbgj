/**
 * Copyright (c) 2016-2019  All rights reserved.
 *
 * https://www.hbgj.io
 *
 * 版权所有，侵权必究！
 */

package io.hbgj.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.hbgj.modules.sys.entity.SysCaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {

}
