package io.hbgj.modules.sys.dao;

import io.hbgj.modules.sys.entity.QyinfomationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface QyinfomationDao extends BaseMapper<QyinfomationEntity> {

    List<HashMap> findAllList();

    List<Map> findByPar(Map<String, Object> params);
}
