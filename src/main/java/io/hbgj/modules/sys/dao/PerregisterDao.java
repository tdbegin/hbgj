package io.hbgj.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.hbgj.modules.sys.entity.PerregisterEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-11-11 10:09:33
 */
@Mapper
public interface PerregisterDao extends BaseMapper<PerregisterEntity> {

    PerregisterEntity login(Map<String, Object> map);
}
