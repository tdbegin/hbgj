package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.CasestudyEntity;
import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.service.CasestudyService;
import io.hbgj.modules.sys.service.FilenameService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-29 10:45:26
 */
@RestController
@RequestMapping("hbgjjk/casestudy")
public class CasestudyController {
    @Autowired
    private CasestudyService casestudyService;
    @Autowired
    private FilenameService filenameService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgj.modules.sys:casestudy:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = casestudyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{newid}")
    //@RequiresPermissions("hbgj.modules.sys:casestudy:info")
    public R info(@PathVariable("newid") Integer newid){
		CasestudyEntity casestudy = casestudyService.getById(newid);
        String domainadd = casestudy.getNewimagepath();
        if (StringUtils.isEmpty(domainadd)){
            return R.ok().put("casestudy", casestudy);
        }
        FilenameEntity byDom = filenameService.getByDom(domainadd);
        String filename = byDom.getFilename().substring(4);

        return R.ok().put("casestudy", casestudy).put("filename", filename);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:casestudy:save")
    public R save(@RequestBody CasestudyEntity casestudy){
		casestudyService.save(casestudy);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:casestudy:update")
    public R update(@RequestBody CasestudyEntity casestudy){
		casestudyService.updateById(casestudy);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:casestudy:delete")
    public R delete(@RequestBody Integer[] newids){
		casestudyService.removeByIds(Arrays.asList(newids));

        return R.ok();
    }

}
