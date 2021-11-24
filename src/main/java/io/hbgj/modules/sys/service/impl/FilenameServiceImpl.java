package io.hbgj.modules.sys.service.impl;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.hbgj.modules.sys.dao.FilenameDao;
import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.service.FilenameService;


@Service("filenameService")
public class FilenameServiceImpl extends ServiceImpl<FilenameDao, FilenameEntity> implements FilenameService {

    @Autowired
    private FilenameDao filenameDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FilenameEntity> page = this.page(
                new Query<FilenameEntity>().getPage(params),
                new QueryWrapper<FilenameEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public FilenameEntity findByid(int i) {
        return filenameDao.findById(i);
    }

}