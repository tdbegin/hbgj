package io.hbgj.modules.sys.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.entity.ZjintroEntity;
import io.hbgj.modules.sys.service.FilenameService;
import io.hbgj.modules.sys.service.ZjintroService;
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
 * @date 2021-11-29 10:45:26
 */
@RestController
@RequestMapping("hbgjjk/zjintro")
public class ZjintroController {
    @Autowired
    private ZjintroService zjintroService;

    @Autowired
    private FilenameService filenameService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgj.modules.sys:zjintro:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = zjintroService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:zjintro:info")
    public R info(@PathVariable("id") Integer id){
		ZjintroEntity zjintro = zjintroService.getById(id);

        return R.ok().put("zjintro", zjintro);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:zjintro:save")
    public R save(@RequestBody ZjintroEntity zjintro){
		zjintroService.save(zjintro);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:zjintro:update")
    public R update(@RequestBody ZjintroEntity zjintro){
		zjintroService.updateById(zjintro);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:zjintro:delete")
    public R delete(@RequestBody Integer[] ids){
        List<Integer> integers = Arrays.asList(ids);

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
		zjintroService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
