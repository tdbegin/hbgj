package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.QyinfoDao;
import io.hbgj.modules.sys.entity.QyinfoEntity;
import io.hbgj.modules.sys.service.QyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("qyinfoService")
public class QyinfoServiceImpl extends ServiceImpl<QyinfoDao, QyinfoEntity> implements QyinfoService {

    @Autowired
    private QyinfoDao qyinfoDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QyinfoEntity> page = this.page(
                new Query<QyinfoEntity>().getPage(params),
                new QueryWrapper<QyinfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<QyinfoEntity> findByName(String qyname) {
        return qyinfoDao.findByName(qyname);
    }

}