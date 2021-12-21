package io.hbgj.modules.sys.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.entity.LegislationsEntity;
import io.hbgj.modules.sys.service.FilenameService;
import io.hbgj.modules.sys.service.LegislationsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-17 09:40:46
 */
@RestController
@RequestMapping("hbgjjk/legislations")
public class LegislationsController {
    @Autowired
    private LegislationsService legislationsService;

    @Autowired
    private FilenameService filenameService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("hbgjjk:legislations:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = legislationsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("hbgjjk:legislations:info")
    public R info(@PathVariable("id") Integer id){
		LegislationsEntity legislations = legislationsService.getById(id);
        String domainadd = legislations.getDomainadd();
        FilenameEntity byDom = filenameService.getByDom(domainadd);
        String filename = byDom.getFilename().substring(4);

        return R.ok().put("legislations", legislations).put("filename", filename);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("hbgjjk:legislations:save")
    public R save(@RequestBody LegislationsEntity legislations)  {
        legislationsService.save(legislations);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("hbgjjk:legislations:update")
    public R update(@RequestBody LegislationsEntity legislations){
		legislationsService.updateById(legislations);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("hbgjjk:legislations:delete")
    public R delete(@RequestBody Integer[] ids){
		legislationsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
