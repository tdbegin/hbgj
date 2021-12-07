package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.PolintroEntity;
import io.hbgj.modules.sys.service.PolintroService;
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
@RequestMapping("hbgjjk/polintro")
public class PolintroController {
    @Autowired
    private PolintroService polintroService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgj.modules.sys:polintro:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = polintroService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{newid}")
    //@RequiresPermissions("hbgj.modules.sys:polintro:info")
    public R info(@PathVariable("newid") Integer newid){
		PolintroEntity polintro = polintroService.getById(newid);

        return R.ok().put("polintro", polintro);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:polintro:save")
    public R save(@RequestBody PolintroEntity polintro){
		polintroService.save(polintro);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:polintro:update")
    public R update(@RequestBody PolintroEntity polintro){
		polintroService.updateById(polintro);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:polintro:delete")
    public R delete(@RequestBody Integer[] newids){
		polintroService.removeByIds(Arrays.asList(newids));

        return R.ok();
    }

}
