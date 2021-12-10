package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.hbgj.modules.sys.entity.BussniessworkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hbgj.modules.sys.service.BussniessworkService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-25 14:14:57
 */
@RestController
@RequestMapping("hbgjjk/bussniesswork")
public class BussniessworkController {
    @Autowired
    private BussniessworkService bussniessworkService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgjjk:bussniesswork:list")
    public R list(@RequestParam Map<String, Object> params){

        PageUtils page = bussniessworkService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:bussniesswork:info")
    public R info(@PathVariable("id") Integer id){
		BussniessworkEntity bussniesswork = bussniessworkService.getById(id);

        return R.ok().put("bussniesswork", bussniesswork);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:bussniesswork:save")
    public R save(@RequestBody BussniessworkEntity bussniesswork){
		bussniessworkService.save(bussniesswork);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:bussniesswork:update")
    public R update(@RequestBody BussniessworkEntity bussniesswork){
		bussniessworkService.updateById(bussniesswork);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:bussniesswork:delete")
    public R delete(@RequestBody Integer[] ids){
		bussniessworkService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }



    @RequestMapping("/fabu")
    //@RequiresPermissions("hbgjjk:bussniesswork:list")
    public R query(@RequestParam Map<String, Object> params){
        List<Map> list = bussniessworkService.queryList();

        return R.ok().put("list", list);
    }

}
