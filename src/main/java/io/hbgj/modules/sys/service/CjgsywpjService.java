package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.CjgsywpjEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-12-24 16:21:57
 */
public interface CjgsywpjService extends IService<CjgsywpjEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<HashMap> findByName(String parentname);
}

