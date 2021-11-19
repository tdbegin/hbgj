package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.QyfcqyDao;
import io.hbgj.modules.sys.entity.QyfcqyEntity;
import io.hbgj.modules.sys.service.QyfcqyService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("qyfcqyService")
public class QyfcqyServiceImpl extends ServiceImpl<QyfcqyDao, QyfcqyEntity> implements QyfcqyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QyfcqyEntity> page = this.page(
                new Query<QyfcqyEntity>().getPage(params),
                new QueryWrapper<QyfcqyEntity>()
        );

        return new PageUtils(page);
    }

}