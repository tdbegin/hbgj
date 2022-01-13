package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.WorkflowEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-01-12 09:01:34
 */
public interface WorkflowService extends IService<WorkflowEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<HashMap> findByPar(String xmname);

    List<HashMap> findPro();

}

