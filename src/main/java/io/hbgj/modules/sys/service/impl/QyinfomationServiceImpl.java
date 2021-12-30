package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.QyinfomationDao;
import io.hbgj.modules.sys.entity.QyinfomationEntity;
import io.hbgj.modules.sys.service.QyinfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("qyinfomationService")
public class QyinfomationServiceImpl extends ServiceImpl<QyinfomationDao, QyinfomationEntity> implements QyinfomationService {


    @Autowired
    private  QyinfomationDao qyinfomationDao ;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QyinfomationEntity> page = this.page(
                new Query<QyinfomationEntity>().getPage(params),
                new QueryWrapper<QyinfomationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<HashMap> findAllList() {
        return qyinfomationDao.findAllList();
    }

}