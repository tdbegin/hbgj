package io.hbgj.modules.sys.dao;

import io.hbgj.modules.sys.entity.CjgsywpjEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-12-24 16:21:57
 */
@Mapper
public interface CjgsywpjDao extends BaseMapper<CjgsywpjEntity> {

    List<HashMap> findByName(String parentname);
}
