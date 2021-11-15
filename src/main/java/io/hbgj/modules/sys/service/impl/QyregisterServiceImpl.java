package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.QyregisterDao;
import io.hbgj.modules.sys.entity.PerregisterEntity;
import io.hbgj.modules.sys.entity.QyregisterEntity;
import io.hbgj.modules.sys.service.QyregisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("qyregisterService")
public class QyregisterServiceImpl extends ServiceImpl<QyregisterDao, QyregisterEntity> implements QyregisterService {

    @Autowired
    private QyregisterDao qyregisterDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QyregisterEntity> page = this.page(
                new Query<QyregisterEntity>().getPage(params),
                new QueryWrapper<QyregisterEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public QyregisterEntity login(HashMap<String, Object> map2) {

        return qyregisterDao.login(map2);
    }

}