package io.hbgj.modules.sys.dao;

import io.hbgj.modules.sys.entity.AnnounceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-11-22 13:24:22
 */
@Mapper
public interface AnnounceDao extends BaseMapper<AnnounceEntity> {

    List<HashMap> findByPar(String parname);
}
