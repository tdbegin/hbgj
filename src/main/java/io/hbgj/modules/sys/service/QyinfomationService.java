package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.QyinfomationEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-19 16:10:02
 */
public interface QyinfomationService extends IService<QyinfomationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<HashMap> findAllList();

    List<Map> findByPar(Map<String, Object> params);
}

