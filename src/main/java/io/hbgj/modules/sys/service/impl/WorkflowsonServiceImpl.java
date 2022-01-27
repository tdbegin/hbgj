package io.hbgj.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.Query;

import io.hbgj.modules.sys.dao.WorkflowsonDao;
import io.hbgj.modules.sys.entity.WorkflowsonEntity;
import io.hbgj.modules.sys.service.WorkflowsonService;


@Service("workflowsonService")
public class WorkflowsonServiceImpl extends ServiceImpl<WorkflowsonDao, WorkflowsonEntity> implements WorkflowsonService {
    @Autowired
    private WorkflowsonDao WorkflowsonDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WorkflowsonEntity> page = this.page(
                new Query<WorkflowsonEntity>().getPage(params),
                new QueryWrapper<WorkflowsonEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<HashMap> findAll(String xmname) {
        return WorkflowsonDao.findAll(xmname);
    }

}