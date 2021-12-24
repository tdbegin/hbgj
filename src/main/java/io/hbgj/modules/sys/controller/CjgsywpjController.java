package io.hbgj.modules.sys.controller;

import java.util.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        Page pages = getPages(page1, limit, list);
        return R.ok().put("page", pages);
        
    }

    //listtopage
    private Page getPages(Integer currentPage, Integer pageSize, List list) {
        Page page = new Page();
        int size = list.size();

        if(pageSize > size) {
            pageSize = size;
        }
        if (pageSize==0){
            pageSize=1;
        }
        // 求出最大页数，防止currentPage越界
        int maxPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;

        if(currentPage > maxPage) {
            currentPage = maxPage;
        }

        // 当前页第一条数据的下标
        int curIdx = currentPage > 1 ? (currentPage - 1) * pageSize : 0;

        List pageList = new ArrayList();

        // 将当前页的数据放进pageList
        for(int i = 0; i < pageSize && curIdx + i < size; i++) {
            pageList.add(list.get(curIdx + i));
        }

        page.setCurrent(currentPage).setSize(pageSize).setTotal(list.size()).setRecords(pageList);
        return page;
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
