package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.AnnounceDao;
import io.hbgj.modules.sys.entity.AnnounceEntity;
import io.hbgj.modules.sys.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;





@Service("announceService")
public class AnnounceServiceImpl extends ServiceImpl<AnnounceDao, AnnounceEntity> implements AnnounceService {

    @Autowired
    private AnnounceDao announceDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AnnounceEntity> page = this.page(
                new Query<AnnounceEntity>().getPage(params),
                new QueryWrapper<AnnounceEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<HashMap> findByPar(String parname) {
        return announceDao.findByPar(parname);
    }

}