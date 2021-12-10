package io.hbgj.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.hbgj.modules.sys.entity.BussniessworkEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-11-25 14:14:57
 */
@Mapper
public interface BussniessworkDao extends BaseMapper<BussniessworkEntity> {

    List<Map> queryList();

}
