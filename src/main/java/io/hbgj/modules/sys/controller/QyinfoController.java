package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.QyinfoEntity;
import io.hbgj.modules.sys.entity.QyinfomationEntity;
import io.hbgj.modules.sys.service.QyinfoService;
import io.hbgj.modules.sys.service.QyinfomationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-11 14:19:06
 */
@RestController
@CrossOrigin
@RequestMapping("hbgjjk/qyinfo")
public class QyinfoController {
    @Autowired
    private QyinfoService qyinfoService;

    @Autowired
    private QyinfomationService qyinfomationService;
    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:qyinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qyinfoService.queryPage(params);
        if (null !=params.get("qyname")){
        List<QyinfoEntity> list =  qyinfoService.findByName((String) params.get("qyname"));
        page.setList(list);
        return R.ok().put("page",page );
        }
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("generator:qyinfo:info")
    public R info(@PathVariable("id") Integer id){
		QyinfoEntity qyinfo = qyinfoService.getById(id);
        return R.ok().put("qyinfo", qyinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("generator:qyinfo:save")
    public R save(@RequestBody QyinfoEntity qyinfo){
		qyinfoService.save(qyinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("generator:qyinfo:update")
    public R update(@RequestBody QyinfoEntity qyinfo){
		qyinfoService.updateById(qyinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("generator:qyinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		qyinfoService.removeByIds(Arrays.asList(ids));
        qyinfomationService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
