package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.PerregisterDao;
import io.hbgj.modules.sys.entity.PerregisterEntity;
import io.hbgj.modules.sys.service.PerregisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("perregisterService")
public class PerregisterServiceImpl extends ServiceImpl<PerregisterDao, PerregisterEntity> implements PerregisterService {

    @Autowired
    private PerregisterDao perregisterDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PerregisterEntity> page = this.page(
                new Query<PerregisterEntity>().getPage(params),
                new QueryWrapper<PerregisterEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PerregisterEntity login(Map<String, Object> map) {
        PerregisterEntity perregisterEntity=  perregisterDao.login(map);

        return perregisterEntity;
    }

}