package io.hbgj.modules.sys.dao;

import io.hbgj.modules.sys.entity.WorkflowEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2022-01-12 09:01:34
 */
@Mapper
public interface WorkflowDao extends BaseMapper<WorkflowEntity> {

    List<HashMap> findByPar(String xmname);

    List<HashMap> findPro();

}
