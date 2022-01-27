package io.hbgj.modules.sys.dao;

import io.hbgj.modules.sys.entity.WorkflowsonEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2022-01-14 10:19:28
 */
@Mapper
public interface WorkflowsonDao extends BaseMapper<WorkflowsonEntity> {

    List<HashMap> findAll(String xmname);

}
