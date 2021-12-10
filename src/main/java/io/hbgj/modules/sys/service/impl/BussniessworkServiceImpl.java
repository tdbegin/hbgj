package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.entity.BussniessworkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import io.hbgj.modules.sys.dao.BussniessworkDao;
import io.hbgj.modules.sys.service.BussniessworkService;


@Service("bussniessworkService")
public class BussniessworkServiceImpl extends ServiceImpl<BussniessworkDao, BussniessworkEntity> implements BussniessworkService {


    @Autowired
    private BussniessworkDao bussniessworkDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BussniessworkEntity> page = this.page(
                new Query<BussniessworkEntity>().getPage(params),
                new QueryWrapper<BussniessworkEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Map> queryList() {
        return bussniessworkDao.queryList();
    }

}