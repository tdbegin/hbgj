package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.QyaqtjEntity;
import io.hbgj.modules.sys.service.QyaqtjService;
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
@RequestMapping("hbgjjk/qyaqtj")
public class QyaqtjController {
    @Autowired
    private QyaqtjService qyaqtjService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("hbgjjk:qyaqtj:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qyaqtjService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("hbgjjk:qyaqtj:info")
    public R info(@PathVariable("id") Integer id){
		QyaqtjEntity qyaqtj = qyaqtjService.getById(id);

        return R.ok().put("qyaqtj", qyaqtj);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("hbgjjk:qyaqtj:save")
    public R save(@RequestBody QyaqtjEntity qyaqtj){
		qyaqtjService.save(qyaqtj);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("hbgjjk:qyaqtj:update")
    public R update(@RequestBody QyaqtjEntity qyaqtj){
		qyaqtjService.updateById(qyaqtj);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("hbgjjk:qyaqtj:delete")
    public R delete(@RequestBody Integer[] ids){
		qyaqtjService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
