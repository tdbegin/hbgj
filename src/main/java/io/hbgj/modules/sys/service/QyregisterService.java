package io.hbgj.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.modules.sys.entity.PerregisterEntity;
import io.hbgj.modules.sys.entity.QyregisterEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-11 10:09:33
 */
public interface QyregisterService extends IService<QyregisterEntity> {

    PageUtils queryPage(Map<String, Object> params);

    QyregisterEntity login(HashMap<String, Object> map2);
}

