package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.AnnounceEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-22 13:24:22
 */
public interface AnnounceService extends IService<AnnounceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

