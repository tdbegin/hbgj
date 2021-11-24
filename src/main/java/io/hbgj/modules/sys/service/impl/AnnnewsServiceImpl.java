package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.AnnnewsDao;
import io.hbgj.modules.sys.entity.AnnnewsEntity;
import io.hbgj.modules.sys.service.AnnnewsService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("annnewsService")
public class AnnnewsServiceImpl extends ServiceImpl<AnnnewsDao, AnnnewsEntity> implements AnnnewsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AnnnewsEntity> page = this.page(
                new Query<AnnnewsEntity>().getPage(params),
                new QueryWrapper<AnnnewsEntity>()
        );

        return new PageUtils(page);
    }

}