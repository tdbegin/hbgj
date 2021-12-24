package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.SupplierEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-12-24 14:38:11
 */
public interface SupplierService extends IService<SupplierEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

