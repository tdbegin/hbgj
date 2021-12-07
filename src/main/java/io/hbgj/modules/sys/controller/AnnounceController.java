package io.hbgj.modules.sys.controller;

import java.util.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.AnnnewsEntity;
import io.hbgj.modules.sys.entity.AnnounceEntity;
import io.hbgj.modules.sys.service.AnnnewsService;
import io.hbgj.modules.sys.service.AnnounceService;
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
 * @date 2021-11-22 13:24:22
 */
@RestController
@RequestMapping("hbgjjk/announce")
public class AnnounceController {
    @Autowired
    private AnnounceService announceService;

    @Autowired
    private AnnnewsService annnewsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("hbgjjk.modules.sys:announce:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = annnewsService.queryPage(params);
        String name = String.valueOf(params.get("parentname"));
//        Integer parentid = Integer.parseInt(params.get("parentid").toString());
        List<HashMap> list =annnewsService.findByName(name);
        Page pages = getPages(page.getCurrPage(), page.getPageSize(), list);

        return R.ok().put("page", pages);
    }

    //listtopage
    private Page getPages(Integer currentPage, Integer pageSize, List list) {
        Page page = new Page();
        int size = list.size();

        if(pageSize > size) {
            pageSize = size;
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
//    @RequiresPermissions("hbgjjk.modules.sys:announce:info")
    public R info(@PathVariable("id") Integer id){
		AnnounceEntity announce = announceService.getById(id);

        return R.ok().put("announce", announce);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("hbgjjk.modules.sys:announce:save")
    public R save(@RequestBody AnnounceEntity announce){
		announceService.save(announce);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("hbgjjk.modules.sys:announce:update")
    public R update(@RequestBody AnnounceEntity announce){
		announceService.updateById(announce);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("hbgjjk.modules.sys:announce:delete")
    public R delete(@RequestBody Integer[] ids){
		announceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }



}
