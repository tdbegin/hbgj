package io.hbgj.modules.sys.controller;

import io.hbgj.common.utils.DownLoadUtils;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.service.FilenameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("files")
public class FileController {

    @Autowired
    private FilenameService filenameService;
    // 将 yml 中的自定义配置注入到这里
    //图片
    @Value("${gorit.file.root.path}")
    private String filePath;
    //文件
    @Value("${gorit.file.root.path1}")
    private String filePath1;
    @Value("${gorit.file.root.path2}")
    private String filePath2;
    @Value("${gorit.file.root.path3}")
    private String filePath3;
    @Value("${gorit.file.root.path4}")
    private String filePath4;
    @Value("${gorit.file.root.path5}")
    private String filePath5;

    private File dest;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    // 文件上传 （可以多文件上传）
    @RequestMapping("/upload")
    public R fileUploads(@RequestParam(name = "file", required = false) MultipartFile file ,@RequestParam Map<String, Object> map,HttpServletRequest requet) throws Exception {
        //时间
        String format = sdf.format(new Date());
        // 获取上传的文件名称
        String fileName = file.getOriginalFilename();
        // 时间 和 日期拼接
//        String newFileName =format+"_"+ fileName;
        String newFileName =getFourRandom()+fileName;
        // 得到文件保存的位置以及新文件名
            String name = String.valueOf(map.get("name"));
        FilenameEntity filenameEntity = new FilenameEntity();
        filenameEntity.setFilename(newFileName);
        filenameEntity.setFilepath(filePath);
        filenameEntity.setTime(format);

        File dest = new File(filePath + newFileName);
        filenameEntity.setFilepath(filePath);
        if (name.equalsIgnoreCase("法律法规")) {
             dest = new File(filePath1 + newFileName);
                filenameEntity.setFilepath(filePath1);
        } else if (name.equalsIgnoreCase("项目决策")) {
             dest = new File(filePath2 + newFileName);
                filenameEntity.setFilepath(filePath2);
        }else if (name.equalsIgnoreCase("项目施工")) {
             dest = new File(filePath3 + newFileName);
                filenameEntity.setFilepath(filePath3);
        }else if (name.equalsIgnoreCase("项目验收")) {
             dest = new File(filePath4 + newFileName);
                filenameEntity.setFilepath(filePath4);
        }else if (name.equalsIgnoreCase("网络大讲堂")) {
             dest = new File(filePath5 + newFileName);
                filenameEntity.setFilepath(filePath5);
        }
//        String bjip = InetAddress.getLocalHost().getHostAddress();
        String bjip ="121.40.90.189";
        String portip= String.valueOf(requet.getLocalPort());
//        String dizhi = filenameEntity.getFilepath().substring(43);
        String dizhi = filenameEntity.getFilepath().substring(64);
        filenameEntity.setDomainadd("http://"+bjip+":"+portip+"/hbgj"+dizhi+filenameEntity.getFilename());
        try {
            // 上传的文件被保存了
            file.transferTo(dest);
            filenameService.save(filenameEntity);
            // 自定义返回的统一的 JSON 格式的数据，可以直接返回这个字符串也是可以的。
            return R.ok("上传成功").put("address", filenameEntity.getDomainadd()).put("name", newFileName);
        } catch (IOException e) {
            R.error();
        }
        // 待完成 —— 文件类型校验工作
        return R.error("上传错误");
    }


   @RequestMapping("/uploads")
    public R httpUpload(@RequestParam(name = "file", required = false) MultipartFile file,HttpServletRequest requet) throws UnknownHostException {
       //时间
       String format = sdf.format(new Date());
       // 获取上传的文件名称
       String fileName = file.getOriginalFilename();
       // 时间 和 日期拼接
//        String newFileName =format+"_"+ fileName;
       String newFileName =getFourRandom()+fileName;
       // 得到文件保存的位置以及新文件名
       FilenameEntity filenameEntity = new FilenameEntity();
       filenameEntity.setFilename(newFileName);
       filenameEntity.setFilepath(filePath);
       filenameEntity.setTime(format);

       File dest = new File(filePath + newFileName);
       filenameEntity.setFilepath(filePath);
//       String bjip = InetAddress.getLocalHost().getHostAddress();
       String bjip ="121.40.90.189";
       String portip= String.valueOf(requet.getLocalPort());

       filenameEntity.setDomainadd("http://"+bjip+":"+portip+"/hbgj/images/"+filenameEntity.getFilename());
       try {
           // 上传的文件被保存了
           file.transferTo(dest);
           filenameService.save(filenameEntity);
           // 自定义返回的统一的 JSON 格式的数据，可以直接返回这个字符串也是可以的。
           return R.ok("上传成功").put("address", filenameEntity.getDomainadd()).put("src", filenameEntity.getDomainadd());
       } catch (IOException e) {
           R.error();
       }
       // 待完成 —— 文件类型校验工作
       return R.error("上传错误");
    }


    public static String getFourRandom(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
            for(int i=1; i<=4-randLength; i++)
                fourRandom = "0" + fourRandom  ;
        }
        return fourRandom;
    }

}
