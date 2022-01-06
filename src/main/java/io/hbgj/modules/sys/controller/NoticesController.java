package io.hbgj.modules.sys.controller;

import java.io.File;
import java.util.*;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.oauth2.ListToPage;
import io.hbgj.modules.sys.service.FilenameService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hbgj.modules.sys.entity.NoticesEntity;
import io.hbgj.modules.sys.service.NoticesService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;



/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-12-22 10:51:38
 */
@RestController
@RequestMapping("hbgjjk/notices")
public class NoticesController {
    @Autowired
    private NoticesService noticesService;

    @Autowired
    private FilenameService filenameService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    ////@RequiresPermissions("hbgj.modules.sys:notices:list")
    public R list(@RequestParam Map<String, Object> params){
        String role = String.valueOf(params.get("role"));
        Integer limit =  Integer.valueOf(String.valueOf(params.get("limit"))) ;
        Integer page1 = Integer.valueOf(String.valueOf(params.get("page"))) ;
        List<HashMap> list =noticesService.findByRole(role);

        Page pages = ListToPage.getPages(page1, limit, list);
        return R.ok().put("page", pages);

    }



    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:notices:info")
    public R info(@PathVariable("id") Integer id){
		NoticesEntity notices = noticesService.getById(id);
        String fallback = notices.getDomainadd();
        if (StringUtils.isEmpty(fallback)){
            return R.ok().put("notices", notices);
        }
        FilenameEntity byDom = filenameService.getByDom(fallback);
        String filename = byDom.getFilename().substring(4);

        return R.ok().put("notices", notices).put("filename", filename);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:notices:save")
    public R save(@RequestBody NoticesEntity notices){
		noticesService.save(notices);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:notices:update")
    public R update(@RequestBody NoticesEntity notices){
		noticesService.updateById(notices);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:notices:delete")
    public R delete(@RequestBody Integer[] ids){
		noticesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
