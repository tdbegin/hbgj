package io.hbgj.modules.sys.controller;

import cn.hutool.json.JSONObject;
import io.hbgj.common.utils.R;
import io.hbgj.modules.sys.entity.FilenameEntity;
import io.hbgj.modules.sys.service.FilenameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("files")
public class FileController {

    @Autowired
    private FilenameService filenameService;
    // 将 yml 中的自定义配置注入到这里
    @Value("${gorit.file.root.path}")
    private String filePath;
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
    public R fileUploads(@RequestParam("file") MultipartFile file ,@RequestParam Map<String, Object> map,HttpServletRequest requet) throws Exception {
        //时间
        String format = sdf.format(new Date());
        // 获取上传的文件名称
        String fileName = file.getOriginalFilename();
        // 时间 和 日期拼接
//        String newFileName =format+"_"+ fileName;
        String newFileName =fileName;
        // 得到文件保存的位置以及新文件名
            String name = String.valueOf(map.get("name"));
        FilenameEntity filenameEntity = new FilenameEntity();
        filenameEntity.setFilename(fileName);
        filenameEntity.setFilepath(filePath);
        filenameEntity.setTime(format);

        File dest = new File(filePath + newFileName);
        filenameEntity.setFilepath(filePath);
        if (name.equalsIgnoreCase("规章制度")) {
             dest = new File(filePath1 + newFileName);
                filenameEntity.setFilepath(filePath1);
        } else if (name.equalsIgnoreCase("1")) {
             dest = new File(filePath2 + newFileName);
                filenameEntity.setFilepath(filePath2);
        }else if (name.equalsIgnoreCase("2")) {
             dest = new File(filePath3 + newFileName);
                filenameEntity.setFilepath(filePath3);
        }else if (name.equalsIgnoreCase("3")) {
             dest = new File(filePath4 + newFileName);
                filenameEntity.setFilepath(filePath4);
        }else if (name.equalsIgnoreCase("4")) {
             dest = new File(filePath5 + newFileName);
                filenameEntity.setFilepath(filePath5);
        }
        String bjip = InetAddress.getLocalHost().getHostAddress();
        String portip= String.valueOf(requet.getLocalPort());
        String dizhi = filenameEntity.getFilepath().substring(2);
        filenameEntity.setDomainadd(bjip+":"+portip+dizhi+filenameEntity.getFilename());
        try {
            // 上传的文件被保存了
            file.transferTo(dest);
            filenameService.save(filenameEntity);
            // 自定义返回的统一的 JSON 格式的数据，可以直接返回这个字符串也是可以的。
            return R.ok("上传成功").put("address", dest).put("name", newFileName);
        } catch (IOException e) {
            R.error();
        }
        // 待完成 —— 文件类型校验工作
        return R.error("上传错误");
    }

    @RequestMapping("/download")
    public void downloadLocal(HttpServletResponse response /*,@RequestParam Map<String, Object> Mapper*/) throws FileNotFoundException {
      /*  String filepath = String.valueOf(map.get("filepath"));
        String filename = String.valueOf(map.get("filename"));*/
       String filepath = "D:/dev1/";
        String filename = "林书辉工作进度11.22.docx";
        // 下载本地文件
        String fileName = filename; // 文件的默认保存名
        // 读到流中
        InputStream inStream = new FileInputStream(filepath+filename);// 文件的存放路径
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  /*  @RequestMapping("/uploads")
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
    }*/

}
