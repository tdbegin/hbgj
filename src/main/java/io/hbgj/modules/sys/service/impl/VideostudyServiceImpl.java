package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.VideostudyDao;
import io.hbgj.modules.sys.entity.VideostudyEntity;
import io.hbgj.modules.sys.service.VideostudyService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("videostudyService")
public class VideostudyServiceImpl extends ServiceImpl<VideostudyDao, VideostudyEntity> implements VideostudyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<VideostudyEntity> page = this.page(
                new Query<VideostudyEntity>().getPage(params),
                new QueryWrapper<VideostudyEntity>()
        );

        return new PageUtils(page);
    }

}