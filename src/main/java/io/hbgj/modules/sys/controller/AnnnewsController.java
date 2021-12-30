package io.hbgj.modules.sys.controller;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.AnnnewsEntity;
import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.oauth2.ListToPage;
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
       /* PageUtils page = annnewsService.queryPage(params);
        String name = String.valueOf(params.get("parentname"));
        if (name == null){
        Page pages = getPages(page.getCurrPage(), page.getPageSize(), page.getList());
            return R.ok().put("page", pages);
        }*/
        String parentname = String.valueOf(params.get("parentname"));
        String firstname = String.valueOf(params.get("firstname"));
        Integer limit =  Integer.valueOf(String.valueOf(params.get("limit"))) ;
        Integer page1 = Integer.valueOf(String.valueOf(params.get("page"))) ;
        List<HashMap> list =annnewsService.findByName(parentname,firstname);
        Page pages = ListToPage.getPages(page1, limit, list);
        return R.ok().put("page", pages);
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
        List<Integer> integers = Arrays.asList(newids);

        for (int i = 0; i < integers.size(); i++) {
            FilenameEntity filename = filenameService.findByaddress(integers.get(i));
            if (null !=filename){
                File folder = new File(filename.getFilepath());
                File[] files = folder.listFiles();
                for(File file:files){
                    if(file.getName().equals(filename.getFilename())){
                        file.delete();
                    }
                }
            }
        }
		annnewsService.removeByIds(Arrays.asList(newids));

        return R.ok();
    }

}
