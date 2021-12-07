package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import io.hbgj.modules.sys.dao.CasestudyDao;
import io.hbgj.modules.sys.entity.CasestudyEntity;
import io.hbgj.modules.sys.service.CasestudyService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("casestudyService")
public class CasestudyServiceImpl extends ServiceImpl<CasestudyDao, CasestudyEntity> implements CasestudyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CasestudyEntity> page = this.page(
                new Query<CasestudyEntity>().getPage(params),
                new QueryWrapper<CasestudyEntity>()
        );

        return new PageUtils(page);
    }

}