package io.hbgj.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;

import io.hbgj.modules.sys.dao.QyhbtjDao;
import io.hbgj.modules.sys.entity.QyhbtjEntity;
import io.hbgj.modules.sys.service.QyhbtjService;


@Service("qyhbtjService")
public class QyhbtjServiceImpl extends ServiceImpl<QyhbtjDao, QyhbtjEntity> implements QyhbtjService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QyhbtjEntity> page = this.page(
                new Query<QyhbtjEntity>().getPage(params),
                new QueryWrapper<QyhbtjEntity>()
        );

        return new PageUtils(page);
    }

}