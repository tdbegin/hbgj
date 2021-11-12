package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.QyinfoDao;
import io.hbgj.modules.sys.entity.QyinfoEntity;
import io.hbgj.modules.sys.service.QyinfoService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("qyinfoService")
public class QyinfoServiceImpl extends ServiceImpl<QyinfoDao, QyinfoEntity> implements QyinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QyinfoEntity> page = this.page(
                new Query<QyinfoEntity>().getPage(params),
                new QueryWrapper<QyinfoEntity>()
        );

        return new PageUtils(page);
    }

}