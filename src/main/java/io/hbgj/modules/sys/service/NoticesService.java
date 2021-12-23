package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.NoticesEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-12-22 10:51:38
 */
public interface NoticesService extends IService<NoticesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<HashMap> findByRole(String role);
}

