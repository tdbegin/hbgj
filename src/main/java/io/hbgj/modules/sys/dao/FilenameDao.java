package io.hbgj.modules.sys.dao;

import io.hbgj.modules.sys.entity.FilenameEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-11-23 13:35:43
 */
@Mapper
public interface FilenameDao extends BaseMapper<FilenameEntity> {

    FilenameEntity findById(int i);

    FilenameEntity findByaddress(Integer id);

    FilenameEntity getByDom(String domainadd);
}
