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

import io.hbgj.modules.sys.dao.WorkflowDao;
import io.hbgj.modules.sys.entity.WorkflowEntity;
import io.hbgj.modules.sys.service.WorkflowService;


@Service("workflowService")
public class WorkflowServiceImpl extends ServiceImpl<WorkflowDao, WorkflowEntity> implements WorkflowService {

    @Autowired
    private WorkflowDao workflowDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WorkflowEntity> page = this.page(
                new Query<WorkflowEntity>().getPage(params),
                new QueryWrapper<WorkflowEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<HashMap> findByPar(String xmname) {
        return workflowDao.findByPar(xmname);
    }

    @Override
    public List<HashMap> findPro() {
        return workflowDao.findPro();
    }

    @Override
    public void deleteAll(String xmname) {
         workflowDao.deleteAll(xmname);
    }

}