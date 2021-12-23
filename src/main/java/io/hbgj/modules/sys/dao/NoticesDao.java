package io.hbgj.modules.sys.dao;

import io.hbgj.modules.sys.entity.NoticesEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-12-22 10:51:38
 */
@Mapper
public interface NoticesDao extends BaseMapper<NoticesEntity> {

    List<HashMap> findByRole(String role);
}
