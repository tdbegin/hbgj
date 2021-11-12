package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.QyinfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-11 14:19:06
 */
public interface QyinfoService extends IService<QyinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

