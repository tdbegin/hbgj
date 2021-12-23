package io.hbgj.modules.sys.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import io.hbgj.config.WebSocket;
import io.hbgj.modules.sys.entity.BussniessworkEntity;
import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.service.FilenameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hbgj.modules.sys.service.BussniessworkService;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-25 14:14:57
 */
@RestController
@RequestMapping("hbgjjk/bussniesswork")
public class BussniessworkController {
    @Autowired
    private BussniessworkService bussniessworkService;

    @Autowired
    private WebSocket webSocket;
    @Autowired
    private FilenameService filenameService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("hbgjjk:bussniesswork:list")
    public R list(@RequestParam Map<String, Object> params){

        PageUtils page = bussniessworkService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("hbgj.modules.sys:bussniesswork:info")
    public R info(@PathVariable("id") Integer id){
		BussniessworkEntity bussniesswork = bussniessworkService.getById(id);
        String domainadd = bussniesswork.getDomainadd();
        if (StringUtils.isEmpty(domainadd)){
            return R.ok().put("bussniesswork", bussniesswork);
        }
        FilenameEntity byDom = filenameService.getByDom(domainadd);
        String filename = byDom.getFilename().substring(4);

        return R.ok().put("bussniesswork", bussniesswork).put("filename", filename);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("hbgj.modules.sys:bussniesswork:save")
    public R save(@RequestBody BussniessworkEntity bussniesswork){
		bussniessworkService.save(bussniesswork);
        // 群发调用
        String qyname = bussniesswork.getQyname();
        String project = bussniesswork.getProject();
        webSocket.sendAllMessage("有新的业务:"+qyname+"--"+project);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("hbgj.modules.sys:bussniesswork:update")
    public R update(@RequestBody BussniessworkEntity bussniesswork){
		bussniessworkService.updateById(bussniesswork);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("hbgj.modules.sys:bussniesswork:delete")
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
		bussniessworkService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }



    @RequestMapping("/fabu")
    //@RequiresPermissions("hbgjjk:bussniesswork:list")
    public R query(@RequestParam Map<String, Object> params){
        List<Map> list = bussniessworkService.queryList();

        return R.ok().put("list", list);
    }

}
