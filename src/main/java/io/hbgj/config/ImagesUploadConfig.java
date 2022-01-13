package io.hbgj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImagesUploadConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/images/**").addResourceLocations("file:C:\\Java\\apache-tomcat-8.5.27\\webapps\\hbgj\\WEB-INF\\classes\\static\\images\\");
//        registry.addResourceHandler("/wjfiles/dev1/**").addResourceLocations("file:C:\\Java\\apache-tomcat-8.5.27\\webapps\\hbgj\\WEB-INF\\classes\\static\\wjfiles\\dev1\\");
//        registry.addResourceHandler("/wjfiles/dev2/**").addResourceLocations("file:C:\\Java\\apache-tomcat-8.5.27\\webapps\\hbgj\\WEB-INF\\classes\\static\\wjfiles\\dev2\\");
//        registry.addResourceHandler("/wjfiles/dev3/**").addResourceLocations("file:C:\\Java\\apache-tomcat-8.5.27\\webapps\\hbgj\\WEB-INF\\classes\\static\\wjfiles\\dev3\\");
//        registry.addResourceHandler("/wjfiles/dev4/**").addResourceLocations("file:C:\\Java\\apache-tomcat-8.5.27\\webapps\\hbgj\\WEB-INF\\classes\\static\\wjfiles\\dev4\\");
//        registry.addResourceHandler("/wjfiles/dev5/**").addResourceLocations("file:C:\\Java\\apache-tomcat-8.5.27\\webapps\\hbgj\\WEB-INF\\classes\\static\\wjfiles\\dev5\\");
        registry.addResourceHandler("/images/**").addResourceLocations("file:D:\\workspace\\hbgj\\src\\main\\resources\\static\\images\\");
        registry.addResourceHandler("/wjfiles/dev1/**").addResourceLocations("file:D:\\workspace\\hbgj\\src\\main\\resources\\static\\wjfiles\\dev1\\");
        registry.addResourceHandler("/wjfiles/dev2/**").addResourceLocations("file:D:\\workspace\\hbgj\\src\\main\\resources\\static\\wjfiles\\dev2\\");
        registry.addResourceHandler("/wjfiles/dev3/**").addResourceLocations("file:D:\\workspace\\hbgj\\src\\main\\resources\\static\\wjfiles\\dev3\\");
        registry.addResourceHandler("/wjfiles/dev4/**").addResourceLocations("file:D:\\workspace\\hbgj\\src\\main\\resources\\static\\wjfiles\\dev4\\");
        registry.addResourceHandler("/wjfiles/dev5/**").addResourceLocations("file:D:\\workspace\\hbgj\\src\\main\\resources\\static\\wjfiles\\dev5\\");
    }
}
//addResourceHandler("/img/**")配置表示释放当前img文件夹下的所有资源（这里我是吧图片放到idea的img目录下）
//addResourceLocations配置你图片在系统中的保存路径：格式是file:路径
//*注意*路径前一定加file：


