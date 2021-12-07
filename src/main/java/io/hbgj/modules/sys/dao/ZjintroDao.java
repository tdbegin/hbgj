package io.hbgj.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.hbgj.modules.sys.entity.ZjintroEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-11-29 10:45:26
 */
@Mapper
public interface ZjintroDao extends BaseMapper<ZjintroEntity> {

    ZjintroEntity findByid(Integer integer);
}
