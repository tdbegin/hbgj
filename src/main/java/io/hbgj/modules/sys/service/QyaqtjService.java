package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.QyaqtjEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-17 09:40:46
 */
public interface QyaqtjService extends IService<QyaqtjEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

