package io.hbgj.modules.sys.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.hbgj.modules.sys.entity.AnnnewsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2021-11-22 13:24:21
 */
@Mapper
public interface AnnnewsDao extends BaseMapper<AnnnewsEntity> {

    List<HashMap> findByName(String name);
}
