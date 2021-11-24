package io.hbgj.modules.sys.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.service.FilenameService;




/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-23 13:35:43
 */
@RestController
@RequestMapping("hbgjjk/filename")
public class FilenameController {
    @Autowired
    private FilenameService filenameService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgj.modules.sys:filename:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = filenameService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:filename:info")
    public R info(@PathVariable("id") Integer id){
		FilenameEntity filename = filenameService.getById(id);

        return R.ok().put("filename", filename);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:filename:save")
    public R save(@RequestBody FilenameEntity filename){
		filenameService.save(filename);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:filename:update")
    public R update(@RequestBody FilenameEntity filename){
		filenameService.updateById(filename);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:filename:delete")
    public R delete(@RequestBody Integer[] ids){
        List<Integer> integers = Arrays.asList(ids);

        for (int i = 0; i < integers.size(); i++) {
        FilenameEntity filename = filenameService.findByid(integers.get(i));
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
		filenameService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }


    @RequestMapping("/ceshi/{id}")
    public R ceshi(@PathVariable("id") Integer id){
        FilenameEntity filename = filenameService.findByid(id);
        return R.ok().put("ceshi", filename);
    }
}
