package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.BussniessworkEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-25 14:14:57
 */
public interface BussniessworkService extends IService<BussniessworkEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

