package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.hbgj.modules.sys.entity.WorkflowEntity;
import io.hbgj.modules.sys.oauth2.ListToPage;
import io.hbgj.modules.sys.service.WorkflowService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hbgj.modules.sys.entity.WorkflowsonEntity;
import io.hbgj.modules.sys.service.WorkflowsonService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;



/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-01-14 10:19:28
 */
@RestController
@RequestMapping("hbgjjk/workflowson")
public class WorkflowsonController {
    @Autowired
    private WorkflowsonService workflowsonService;
    @Autowired
    private WorkflowService workflowService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgj.modules.sys:workflowson:list")
    public R list(@RequestParam Map<String, Object> params){

        Integer id =  Integer.valueOf(String.valueOf(params.get("id"))) ;
        WorkflowEntity workflow = workflowService.getById(id);
        String xmname = workflow.getXmname();
        List<HashMap> list =workflowsonService.findAll(xmname);
        return R.ok().put("page", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:workflowson:info")
    public R info(@PathVariable("id") Integer id){
		WorkflowsonEntity workflowson = workflowsonService.getById(id);

        return R.ok().put("workflowson", workflowson);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:workflowson:save")
    public R save(@RequestBody WorkflowsonEntity workflowson){
		workflowsonService.save(workflowson);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:workflowson:update")
    public R update(@RequestBody WorkflowsonEntity workflowson){
		workflowsonService.updateById(workflowson);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:workflowson:delete")
    public R delete(@RequestBody Integer[] ids){
		workflowsonService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
