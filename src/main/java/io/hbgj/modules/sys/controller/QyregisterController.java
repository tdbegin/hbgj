package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.QyregisterEntity;
import io.hbgj.modules.sys.oauth2.Md5Util;
import io.hbgj.modules.sys.service.QyregisterService;
import org.apache.commons.lang.StringUtils;
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
 * @date 2021-11-11 10:09:33
 */
@RestController
@RequestMapping("hbgjjk/qyregister")
public class QyregisterController {
    @Autowired
    private QyregisterService qyregisterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:qyregister:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qyregisterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{registerid}")
//    @RequiresPermissions("generator:qyregister:info")
    public R info(@PathVariable("registerid") Long registerid){
		QyregisterEntity qyregister = qyregisterService.getById(registerid);

        return R.ok().put("qyregister", qyregister);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("generator:qyregister:save")
    public R save(@RequestBody QyregisterEntity qyregister) throws Exception {
        String oldpassword = qyregister.getPassword();
        String password = Md5Util.encodeByMd5(oldpassword);
        qyregister.setPassword(password);
        HashMap<String, Object> map = new HashMap<>();
        map.put("telphone",qyregister.getTelphone() );
        map.put("password",qyregister.getPassword() );
        QyregisterEntity qyregisterEntity= qyregisterService.login(map);
        if (qyregisterEntity!=null){
            return R.error("账号已注册");
        }
        qyregisterService.save(qyregister);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("generator:qyregister:update")
    public R update(@RequestBody QyregisterEntity qyregister) throws Exception {
        String oldpassword = qyregister.getPassword();
        if (StringUtils.isNotEmpty(oldpassword)){
        String password = Md5Util.encodeByMd5(oldpassword);
        qyregister.setPassword(password);
        }
		qyregisterService.updateById(qyregister);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("generator:qyregister:delete")
    public R delete(@RequestBody Long[] registerids){
		qyregisterService.removeByIds(Arrays.asList(registerids));

        return R.ok();
    }

}
