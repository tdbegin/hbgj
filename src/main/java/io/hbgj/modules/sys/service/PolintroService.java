package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.PolintroEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-29 10:45:26
 */
public interface PolintroService extends IService<PolintroEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

