package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.LegislationsDao;
import io.hbgj.modules.sys.entity.LegislationsEntity;
import io.hbgj.modules.sys.service.LegislationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("legislationsService")
public class LegislationsServiceImpl extends ServiceImpl<LegislationsDao, LegislationsEntity> implements LegislationsService {

    @Autowired
    private LegislationsDao legislationsDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LegislationsEntity> page = this.page(
                new Query<LegislationsEntity>().getPage(params),
                new QueryWrapper<LegislationsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<HashMap> findByZone(String zone) {
        return legislationsDao.findByZone(zone);
    }

}