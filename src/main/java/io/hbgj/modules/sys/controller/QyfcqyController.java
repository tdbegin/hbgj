package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.QyfcqyEntity;
import io.hbgj.modules.sys.service.QyfcqyService;
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
 * @date 2021-11-17 09:40:46
 */
@RestController
@RequestMapping("hbgjjk/qyfcqy")
public class QyfcqyController {
    @Autowired
    private QyfcqyService qyfcqyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("hbgjjk:qyfcqy:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qyfcqyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("hbgjjk:qyfcqy:info")
    public R info(@PathVariable("id") Integer id){
		QyfcqyEntity qyfcqy = qyfcqyService.getById(id);

        return R.ok().put("qyfcqy", qyfcqy);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("hbgjjk:qyfcqy:save")
    public R save(@RequestBody QyfcqyEntity qyfcqy){
		qyfcqyService.save(qyfcqy);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("hbgjjk:qyfcqy:update")
    public R update(@RequestBody QyfcqyEntity qyfcqy){
		qyfcqyService.updateById(qyfcqy);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("hbgjjk:qyfcqy:delete")
    public R delete(@RequestBody Integer[] ids){
		qyfcqyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
