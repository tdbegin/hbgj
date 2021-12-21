package io.hbgj.modules.sys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.hbgj.common.utils.PageUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.PerregisterEntity;
import io.hbgj.modules.sys.entity.QyregisterEntity;
import io.hbgj.modules.sys.oauth2.Md5Util;
import io.hbgj.modules.sys.service.PerregisterService;
import io.hbgj.modules.sys.service.QyregisterService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2021-11-11 10:09:33
 */
@RestController
@RequestMapping("hbgjjk/perregister")
public class PerregisterController {
    @Autowired
    private PerregisterService perregisterService;

    @Autowired
    private QyregisterService qyregisterService;
    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:perregister:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = perregisterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("generator:perregister:info")
    public R info(@PathVariable("id") Integer id){
		PerregisterEntity perregister = perregisterService.getById(id);

        return R.ok().put("perregister", perregister);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("generator:perregister:save")
    public R save(@RequestBody PerregisterEntity perregister) throws Exception {
        String oldpassword = perregister.getPassword();
        String password = Md5Util.encodeByMd5(oldpassword);
        perregister.setPassword(password);
        HashMap<String, Object> map = new HashMap<>();
        map.put("telphone",perregister.getTelphone() );
        map.put("password",perregister.getPassword() );
        PerregisterEntity perregisterEntity =  perregisterService.login(map);
        if (perregisterEntity!=null){
            return R.error("账号已注册");
        }
        perregisterService.save(perregister);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("generator:perregister:update")
    public R update(@RequestBody PerregisterEntity perregister){
		perregisterService.updateById(perregister);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//  www  @RequiresPermissions("generator:perregister:delete")
    public R delete(@RequestBody Integer[] ids){
		perregisterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


    @RequestMapping("/login")
//  www  @RequiresPermissions("generator:perregister:delete")
    public R login(@RequestParam Map<String, Object> map, HttpServletRequest request) throws Exception {
        String oldpassword = String.valueOf(map.get("password"));
        String password = Md5Util.encodeByMd5(oldpassword);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("telphone",map.get("telphone") );
        map2.put("password",password );
        String role = String.valueOf(map.get("role"));

        if (role.equals("personal")){
            PerregisterEntity perregisterEntity =  perregisterService.login(map2);
                if (perregisterEntity ==null){
                    return R.error("手机号或密码错误").put("code", false);
            }
            return R.ok().put("perregister",perregisterEntity );
        }else if (role.equals("company")){
             QyregisterEntity qyregisterEntity= qyregisterService.login(map2);
                if (qyregisterEntity==null){
                     return R.error("手机号或密码错误").put("code", false);
            }
            return R.ok().put("qyregisterEntity",qyregisterEntity);
        }
             return R.error("选择角色错误");
    }
}
