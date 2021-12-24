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

import io.hbgj.modules.sys.dao.CjgsywpjDao;
import io.hbgj.modules.sys.entity.CjgsywpjEntity;
import io.hbgj.modules.sys.service.CjgsywpjService;


@Service("cjgsywpjService")
public class CjgsywpjServiceImpl extends ServiceImpl<CjgsywpjDao, CjgsywpjEntity> implements CjgsywpjService {


    @Autowired
    private CjgsywpjDao cjgsywpjDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CjgsywpjEntity> page = this.page(
                new Query<CjgsywpjEntity>().getPage(params),
                new QueryWrapper<CjgsywpjEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<HashMap> findByName(String parentname) {
        return cjgsywpjDao.findByName(parentname);
    }

}