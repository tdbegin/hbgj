/**
 * Copyright (c) 2016-2019  All rights reserved.
 *
 * https://www.hbgj.io
 *
 * 版权所有，侵权必究！
 */

package io.hbgj.modules.sys.redis;


import io.hbgj.common.utils.RedisKeys;
import io.hbgj.common.utils.RedisUtils;
import io.hbgj.modules.sys.entity.SysConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 系统配置Redis
 *
 * @author Mark sunlightcs@gmail.com
 */
@Component
public class SysConfigRedis {
    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysConfigEntity config) {
        if(config == null){
            return ;
        }
        String key = RedisKeys.getSysConfigKey(config.getParamKey());
        redisUtils.set(key, config);
    }

    public void delete(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }

    public SysConfigEntity get(String configKey){
        String key = RedisKeys.getSysConfigKey(configKey);
        return redisUtils.get(key, SysConfigEntity.class);
    }
}
