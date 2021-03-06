package io.hbgj.modules.sys.dao;

import io.hbgj.modules.sys.entity.LegislationsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-11-17 09:40:46
 */
@Mapper
public interface LegislationsDao extends BaseMapper<LegislationsEntity> {

    List<HashMap> findByZone(String zone);
}
