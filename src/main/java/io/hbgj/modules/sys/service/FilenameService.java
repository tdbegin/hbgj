package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.FilenameEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-23 13:35:43
 */
public interface FilenameService extends IService<FilenameEntity> {

    PageUtils queryPage(Map<String, Object> params);

    FilenameEntity findByid(int i);

    FilenameEntity findByaddress(Integer id);

    FilenameEntity getByDom(String domainadd);
}

