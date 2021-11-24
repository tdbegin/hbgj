package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.AnnounceEntity;
import io.hbgj.modules.sys.service.AnnounceService;
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
 * @date 2021-11-22 13:24:22
 */
@RestController
@RequestMapping("hbgjjk.modules.sys/announce")
public class AnnounceController {
    @Autowired
    private AnnounceService announceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("hbgjjk.modules.sys:announce:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = announceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("hbgjjk.modules.sys:announce:info")
    public R info(@PathVariable("id") Integer id){
		AnnounceEntity announce = announceService.getById(id);

        return R.ok().put("announce", announce);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("hbgjjk.modules.sys:announce:save")
    public R save(@RequestBody AnnounceEntity announce){
		announceService.save(announce);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("hbgjjk.modules.sys:announce:update")
    public R update(@RequestBody AnnounceEntity announce){
		announceService.updateById(announce);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("hbgjjk.modules.sys:announce:delete")
    public R delete(@RequestBody Integer[] ids){
		announceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
