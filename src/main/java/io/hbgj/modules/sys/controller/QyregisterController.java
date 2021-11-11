package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.QyregisterEntity;
import io.hbgj.modules.sys.service.QyregisterService;
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
@RequestMapping("generator/qyregister")
public class QyregisterController {
    @Autowired
    private QyregisterService qyregisterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:qyregister:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qyregisterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{registerid}")
//    @RequiresPermissions("generator:qyregister:info")
    public R info(@PathVariable("registerid") Long registerid){
		QyregisterEntity qyregister = qyregisterService.getById(registerid);

        return R.ok().put("qyregister", qyregister);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("generator:qyregister:save")
    public R save(@RequestBody QyregisterEntity qyregister){
		qyregisterService.save(qyregister);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("generator:qyregister:update")
    public R update(@RequestBody QyregisterEntity qyregister){
		qyregisterService.updateById(qyregister);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("generator:qyregister:delete")
    public R delete(@RequestBody Long[] registerids){
		qyregisterService.removeByIds(Arrays.asList(registerids));

        return R.ok();
    }

}
