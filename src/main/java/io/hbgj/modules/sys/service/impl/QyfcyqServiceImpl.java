package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.QyfcyqDao;
import io.hbgj.modules.sys.entity.QyfcyqEntity;
import io.hbgj.modules.sys.service.QyfcyqService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("qyfcyqService")
public class QyfcyqServiceImpl extends ServiceImpl<QyfcyqDao, QyfcyqEntity> implements QyfcyqService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QyfcyqEntity> page = this.page(
                new Query<QyfcyqEntity>().getPage(params),
                new QueryWrapper<QyfcyqEntity>()
        );

        return new PageUtils(page);
    }

}