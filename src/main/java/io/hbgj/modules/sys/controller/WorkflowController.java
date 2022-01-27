package io.hbgj.modules.sys.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.hbgj.modules.sys.oauth2.ListToPage;
import io.hbgj.modules.sys.service.WorkflowsonService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hbgj.modules.sys.entity.WorkflowEntity;
import io.hbgj.modules.sys.service.WorkflowService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;



/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2022-01-12 09:01:34
 */
@RestController
@RequestMapping("hbgjjk/workflow")
public class WorkflowController {
    @Autowired
    private WorkflowService workflowService;
    @Autowired
    private WorkflowsonService workflowsonService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgj.modules.sys:workflow:list")
    public R list(@RequestParam Map<String, Object> params){

        Integer limit =  Integer.valueOf(String.valueOf(params.get("limit"))) ;
        Integer currentpage= Integer.valueOf(String.valueOf(params.get("page"))) ;
        List<HashMap> list =workflowService.findPro();
        Page pages = ListToPage.getPages(currentpage, limit, list);
        return R.ok().put("page", pages);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:workflow:info")
    public R info(@PathVariable("id") Integer id){
		WorkflowEntity workflow = workflowService.getById(id);
//        String xmname = workflow.getXmname();
//        List<HashMap> list =workflowsonService.findAll(xmname);
        return R.ok().put("workflow", workflow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:workflow:save")
    public R save(@RequestBody WorkflowEntity workflow){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dateTime = sdf.format(System.currentTimeMillis());
//        workflow.setTimes(dateTime);
		workflowService.save(workflow);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:workflow:update")
    public R update(@RequestBody WorkflowEntity workflow){
		workflowService.updateById(workflow);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:workflow:delete")
    public R delete(@RequestBody Integer[] ids){
		workflowService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @RequestMapping("/deleteAll")
    //@RequiresPermissions("hbgj.modules.sys:workflow:delete")
    public R deleteAll(@RequestParam Map<String, Object> params){
        String xmname = String.valueOf(params.get("xmname"));
        workflowService.deleteAll(xmname);
        return R.ok();
    }
}
