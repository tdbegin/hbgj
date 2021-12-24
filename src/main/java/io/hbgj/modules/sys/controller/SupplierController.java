package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hbgj.modules.sys.entity.SupplierEntity;
import io.hbgj.modules.sys.service.SupplierService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;



/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-12-24 14:38:11
 */
@RestController
@RequestMapping("hbgjjk/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgj.modules.sys:supplier:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = supplierService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:supplier:info")
    public R info(@PathVariable("id") Integer id){
		SupplierEntity supplier = supplierService.getById(id);

        return R.ok().put("supplier", supplier);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:supplier:save")
    public R save(@RequestBody SupplierEntity supplier){
		supplierService.save(supplier);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:supplier:update")
    public R update(@RequestBody SupplierEntity supplier){
		supplierService.updateById(supplier);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:supplier:delete")
    public R delete(@RequestBody Integer[] ids){
		supplierService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
