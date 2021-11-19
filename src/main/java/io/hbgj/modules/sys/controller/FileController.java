package io.hbgj.modules.sys.controller;

import cn.hutool.json.JSONObject;
import io.hbgj.common.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("files")
public class FileController {
    // 将 yml 中的自定义配置注入到这里
    @Value("${gorit.file.root.path}")
    private String filePath;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // 文件上传 （可以多文件上传）
    @RequestMapping("/upload")
    public R fileUploads(@RequestParam("file") MultipartFile file) throws Exception {
        String format = sdf.format(new Date());
        // 获取上传的文件名称
        String fileName = file.getOriginalFilename();
        // 时间 和 日期拼接
        String newFileName =format+"_"+ fileName;
        // 得到文件保存的位置以及新文件名
        File dest = new File(filePath + newFileName);
        try {
            // 上传的文件被保存了
            file.transferTo(dest);
            // 自定义返回的统一的 JSON 格式的数据，可以直接返回这个字符串也是可以的。
            return R.ok("上传成功").put("address", dest).put("name", newFileName);
        } catch (IOException e) {
            R.error();
        }
        // 待完成 —— 文件类型校验工作
        return R.error("上传错误");
    }

    @RequestMapping("/uploads")
    public String httpUpload(@RequestParam("files") MultipartFile files[]){
        String format = sdf.format(new Date());
        JSONObject object=new JSONObject();
        for(int i=0;i<files.length;i++){
            String fileName = files[i].getOriginalFilename();  // 文件名
            File dest = new File(filePath +format+"_" +fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                files[i].transferTo(dest);
                object.put("address"+i, dest);
            } catch (Exception e) {
                object.put("result","程序错误，请重新上传");
                return object.toString();
            }
        }
        object.put("result","文件上传成功");
        return object.toString();
    }

}
