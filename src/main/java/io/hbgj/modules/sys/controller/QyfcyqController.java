package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.QyfcyqEntity;
import io.hbgj.modules.sys.service.QyfcyqService;
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
@RequestMapping("hbgjjk/qyfcyq")
public class QyfcyqController {
    @Autowired
    private QyfcyqService qyfcyqService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("hbgjjk:qyfcyq:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qyfcyqService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("hbgjjk:qyfcyq:info")
    public R info(@PathVariable("id") Integer id){
		QyfcyqEntity qyfcyq = qyfcyqService.getById(id);

        return R.ok().put("qyfcyq", qyfcyq);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("hbgjjk:qyfcyq:save")
    public R save(@RequestBody QyfcyqEntity qyfcyq){
		qyfcyqService.save(qyfcyq);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("hbgjjk:qyfcyq:update")
    public R update(@RequestBody QyfcyqEntity qyfcyq){
		qyfcyqService.updateById(qyfcyq);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("hbgjjk:qyfcyq:delete")
    public R delete(@RequestBody Integer[] ids){
		qyfcyqService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
