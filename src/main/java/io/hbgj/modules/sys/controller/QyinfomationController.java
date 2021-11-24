package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.QyinfomationEntity;
import io.hbgj.modules.sys.service.QyinfomationService;
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
 * @date 2021-11-19 16:10:02
 */
@RestController
@RequestMapping("hbgjjk/qyinfomation")
public class QyinfomationController {
    @Autowired
    private QyinfomationService qyinfomationService;


    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("hbgjjk:qyinfomation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qyinfomationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("hbgjjk:qyinfomation:info")
    public R info(@PathVariable("id") Integer id){
		QyinfomationEntity qyinfomation = qyinfomationService.getById(id);

        return R.ok().put("qyinfomation", qyinfomation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("hbgjjk:qyinfomation:save")
    public R save(@RequestBody QyinfomationEntity qyinfomation){
		qyinfomationService.save(qyinfomation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("hbgjjk:qyinfomation:update")
    public R update(@RequestBody QyinfomationEntity qyinfomation){
		qyinfomationService.updateById(qyinfomation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("hbgjjk:qyinfomation:delete")
    public R delete(@RequestBody Integer[] ids){
		qyinfomationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
