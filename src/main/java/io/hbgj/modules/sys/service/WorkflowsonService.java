package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.WorkflowsonEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-01-14 10:19:28
 */
public interface WorkflowsonService extends IService<WorkflowsonEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<HashMap> findAll(String xmname);
}

