package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.QyaqtjDao;
import io.hbgj.modules.sys.entity.QyaqtjEntity;
import io.hbgj.modules.sys.service.QyaqtjService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("qyaqtjService")
public class QyaqtjServiceImpl extends ServiceImpl<QyaqtjDao, QyaqtjEntity> implements QyaqtjService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QyaqtjEntity> page = this.page(
                new Query<QyaqtjEntity>().getPage(params),
                new QueryWrapper<QyaqtjEntity>()
        );

        return new PageUtils(page);
    }

}