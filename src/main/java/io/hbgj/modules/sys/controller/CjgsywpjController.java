package io.hbgj.modules.sys.controller;

import java.util.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.hbgj.modules.sys.oauth2.ListToPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hbgj.modules.sys.entity.CjgsywpjEntity;
import io.hbgj.modules.sys.service.CjgsywpjService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;



/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-12-24 16:21:57
 */
@RestController
@RequestMapping("hbgjjk/cjgsywpj")
public class CjgsywpjController {
    @Autowired
    private CjgsywpjService cjgsywpjService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgj:list")
    public R list(@RequestParam Map<String, Object> params){
        
        String parentname = String.valueOf(params.get("parentname"));
        Integer limit =  Integer.valueOf(String.valueOf(params.get("limit"))) ;
        Integer page1 = Integer.valueOf(String.valueOf(params.get("page"))) ;
        List<HashMap> list =cjgsywpjService.findByName(parentname);
        Page pages =ListToPage.getPages(page1, limit, list);
        return R.ok().put("page", pages);
        
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:cjgsywpj:info")
    public R info(@PathVariable("id") Integer id){
		CjgsywpjEntity cjgsywpj = cjgsywpjService.getById(id);

        return R.ok().put("cjgsywpj", cjgsywpj);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:cjgsywpj:save")
    public R save(@RequestBody CjgsywpjEntity cjgsywpj){
		cjgsywpjService.save(cjgsywpj);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:cjgsywpj:update")
    public R update(@RequestBody CjgsywpjEntity cjgsywpj){
		cjgsywpjService.updateById(cjgsywpj);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:cjgsywpj:delete")
    public R delete(@RequestBody Integer[] ids){
		cjgsywpjService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
