package io.hbgj.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.hbgj.modules.sys.entity.PerregisterEntity;
import io.hbgj.modules.sys.entity.QyregisterEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-11-11 10:09:33
 */
@Mapper
public interface QyregisterDao extends BaseMapper<QyregisterEntity> {

    QyregisterEntity login(HashMap<String, Object> map2);
}
