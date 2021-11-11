package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.PerregisterEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-11 10:09:33
 */
public interface PerregisterService extends IService<PerregisterEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

