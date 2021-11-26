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

import io.hbgj.modules.sys.entity.QyhbtjEntity;
import io.hbgj.modules.sys.service.QyhbtjService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;



/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-25 14:14:57
 */
@RestController
@RequestMapping("hbgjjk/qyhbtj")
public class QyhbtjController {
    @Autowired
    private QyhbtjService qyhbtjService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgj.modules.sys:qyhbtj:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qyhbtjService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:qyhbtj:info")
    public R info(@PathVariable("id") Long id){
		QyhbtjEntity qyhbtj = qyhbtjService.getById(id);

        return R.ok().put("qyhbtj", qyhbtj);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:qyhbtj:save")
    public R save(@RequestBody QyhbtjEntity qyhbtj){

		qyhbtjService.save(qyhbtj);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:qyhbtj:update")
    public R update(@RequestBody QyhbtjEntity qyhbtj){
		qyhbtjService.updateById(qyhbtj);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:qyhbtj:delete")
    public R delete(@RequestBody Long[] ids){
		qyhbtjService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
