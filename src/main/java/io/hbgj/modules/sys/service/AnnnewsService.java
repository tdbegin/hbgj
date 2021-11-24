package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.AnnnewsEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-22 13:24:21
 */
public interface AnnnewsService extends IService<AnnnewsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

