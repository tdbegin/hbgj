package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.VideostudyEntity;
import io.hbgj.modules.sys.service.VideostudyService;
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
@RequestMapping("hbgjjk/videostudy")
public class VideostudyController {
    @Autowired
    private VideostudyService videostudyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgj.modules.sys:videostudy:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = videostudyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:videostudy:info")
    public R info(@PathVariable("id") Integer id){
		VideostudyEntity videostudy = videostudyService.getById(id);

        return R.ok().put("videostudy", videostudy);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:videostudy:save")
    public R save(@RequestBody VideostudyEntity videostudy){
		videostudyService.save(videostudy);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:videostudy:update")
    public R update(@RequestBody VideostudyEntity videostudy){
		videostudyService.updateById(videostudy);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:videostudy:delete")
    public R delete(@RequestBody Integer[] ids){
		videostudyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
