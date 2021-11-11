package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.PerregisterEntity;
import io.hbgj.modules.sys.service.PerregisterService;
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
 * @date 2021-11-11 10:09:33
 */
@RestController
@RequestMapping("generator/perregister")
public class PerregisterController {
    @Autowired
    private PerregisterService perregisterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:perregister:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = perregisterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("generator:perregister:info")
    public R info(@PathVariable("id") Integer id){
		PerregisterEntity perregister = perregisterService.getById(id);

        return R.ok().put("perregister", perregister);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("generator:perregister:save")
    public R save(@RequestBody PerregisterEntity perregister){
		perregisterService.save(perregister);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("generator:perregister:update")
    public R update(@RequestBody PerregisterEntity perregister){
		perregisterService.updateById(perregister);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//  www  @RequiresPermissions("generator:perregister:delete")
    public R delete(@RequestBody Integer[] ids){
		perregisterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
