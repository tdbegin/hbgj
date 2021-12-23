package io.hbgj.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;

import io.hbgj.modules.sys.dao.NoticesDao;
import io.hbgj.modules.sys.entity.NoticesEntity;
import io.hbgj.modules.sys.service.NoticesService;


@Service("noticesService")
public class NoticesServiceImpl extends ServiceImpl<NoticesDao, NoticesEntity> implements NoticesService {

    @Autowired
    private NoticesDao noticesDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NoticesEntity> page = this.page(
                new Query<NoticesEntity>().getPage(params),
                new QueryWrapper<NoticesEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<HashMap> findByRole(String role) {
        return noticesDao.findByRole(role);

    }

}