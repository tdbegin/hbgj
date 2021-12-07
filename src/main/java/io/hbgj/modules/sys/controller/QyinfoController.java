package io.hbgj.modules.sys.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.QyinfoEntity;
import io.hbgj.modules.sys.entity.QyinfomationEntity;
import io.hbgj.modules.sys.service.QyinfoService;
import io.hbgj.modules.sys.service.QyinfomationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
        boolean qyname = StringUtils.isEmpty(String.valueOf(params.get("qyname")));
        if (qyname =false){
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


    //网站访问量
    @RequestMapping("/getcount")
    public void getCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
            int totalCount=1;//默认访问量为1
        //获取网站访问量
        Object count = request.getServletContext().getAttribute("count");
        //判断count是否为null，不为null表示曾经访问过，直接将count赋值给totalCount
        if(count!=null) {
            totalCount=(int)count;
        }
        if (totalCount % 50 == 49){

        }
        response.setHeader("Content-type", "text/html; charset=utf-8") ;
        //访问次数累加
        request.getServletContext().setAttribute("count",totalCount+1);
        response.getWriter().println("网站访问量为："+totalCount);	//输出到界面

    }

}
