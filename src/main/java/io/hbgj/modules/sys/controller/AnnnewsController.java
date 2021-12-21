package io.hbgj.modules.sys.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.AnnnewsEntity;
import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.service.AnnnewsService;
import io.hbgj.modules.sys.service.FilenameService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-22 13:24:21
 */
@RestController
@RequestMapping("hbgjjk/annnews")
public class AnnnewsController {
    @Autowired
    private AnnnewsService annnewsService;
    @Autowired
    private FilenameService filenameService;
    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("hbgjjk.modules.sys:annnews:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = annnewsService.queryPage(params);
        String name = String.valueOf(params.get("parentname"));
        if (name == null){
        Page pages = getPages(page.getCurrPage(), page.getPageSize(), page.getList());
            return R.ok().put("page", pages);
        }
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
    @RequestMapping("/info/{newid}")
//    @RequiresPermissions("hbgjjk.modules.sys:annnews:info")
    public R info(@PathVariable("newid") Integer newid){
		AnnnewsEntity annnews = annnewsService.getById(newid);
        String domainadd = annnews.getDomainadd();
        if (StringUtils.isEmpty(domainadd)){
            return R.ok().put("annnews", annnews);
        }
        FilenameEntity byDom = filenameService.getByDom(domainadd);
        String filename = byDom.getFilename().substring(4);

        return R.ok().put("annnews", annnews).put("filename", filename);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("hbgjjk.modules.sys:annnews:save")
    public R save(@RequestBody AnnnewsEntity annnews){
		annnewsService.save(annnews);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("hbgjjk.modules.sys:annnews:update")
    public R update(@RequestBody AnnnewsEntity annnews){
		annnewsService.updateById(annnews);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("hbgjjk.modules.sys:annnews:delete")
    public R delete(@RequestBody Integer[] newids){
		annnewsService.removeByIds(Arrays.asList(newids));

        return R.ok();
    }

}
