package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.ZjintroDao;
import io.hbgj.modules.sys.entity.ZjintroEntity;
import io.hbgj.modules.sys.service.ZjintroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("zjintroService")
public class ZjintroServiceImpl extends ServiceImpl<ZjintroDao, ZjintroEntity> implements ZjintroService {

    @Autowired
    private ZjintroDao zjintroDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ZjintroEntity> page = this.page(
                new Query<ZjintroEntity>().getPage(params),
                new QueryWrapper<ZjintroEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public ZjintroEntity findByid(Integer integer) {
        return zjintroDao.findByid(integer);
    }

}