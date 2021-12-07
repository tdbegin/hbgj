package io.hbgj.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.PolintroDao;
import io.hbgj.modules.sys.entity.PolintroEntity;
import io.hbgj.modules.sys.service.PolintroService;
import org.springframework.stereotype.Service;
import java.util.Map;



@Service("polintroService")
public class PolintroServiceImpl extends ServiceImpl<PolintroDao, PolintroEntity> implements PolintroService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PolintroEntity> page = this.page(
                new Query<PolintroEntity>().getPage(params),
                new QueryWrapper<PolintroEntity>()
        );

        return new PageUtils(page);
    }

}