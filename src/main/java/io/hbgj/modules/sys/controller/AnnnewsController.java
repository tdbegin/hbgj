package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.AnnnewsEntity;
import io.hbgj.modules.sys.service.AnnnewsService;
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
 * @date 2021-11-22 13:24:21
 */
@RestController
@RequestMapping("hbgjjk/annnews")
public class AnnnewsController {
    @Autowired
    private AnnnewsService annnewsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("hbgjjk.modules.sys:annnews:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = annnewsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{newid}")
//    @RequiresPermissions("hbgjjk.modules.sys:annnews:info")
    public R info(@PathVariable("newid") Integer newid){
		AnnnewsEntity annnews = annnewsService.getById(newid);

        return R.ok().put("annnews", annnews);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("hbgjjk.modules.sys:annnews:save")
    public R save(@RequestBody AnnnewsEntity annnews){
		annnewsService.save(annnews);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("hbgjjk.modules.sys:annnews:update")
    public R update(@RequestBody AnnnewsEntity annnews){
		annnewsService.updateById(annnews);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("hbgjjk.modules.sys:annnews:delete")
    public R delete(@RequestBody Integer[] newids){
		annnewsService.removeByIds(Arrays.asList(newids));

        return R.ok();
    }

}
