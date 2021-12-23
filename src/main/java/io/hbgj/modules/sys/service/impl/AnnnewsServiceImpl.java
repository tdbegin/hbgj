package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.AnnnewsDao;
import io.hbgj.modules.sys.entity.AnnnewsEntity;
import io.hbgj.modules.sys.service.AnnnewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("annnewsService")
public class AnnnewsServiceImpl extends ServiceImpl<AnnnewsDao, AnnnewsEntity> implements AnnnewsService {
    @Autowired
    private AnnnewsDao annnewsDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AnnnewsEntity> page = this.page(
                new Query<AnnnewsEntity>().getPage(params),
                new QueryWrapper<AnnnewsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<HashMap> findByName(String parentname, String firstname) {

        return annnewsDao.findByName(parentname,firstname);
    }

    @Override
    public List<HashMap> findByHtName(String parentname) {
        return annnewsDao.findByHtName(parentname);
    }

}