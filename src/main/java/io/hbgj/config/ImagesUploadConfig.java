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
//addResourceHandler("/img/**")????????????????????????img?????????????????????????????????????????????????????????idea???img????????????
//addResourceLocations??????????????????????????????????????????????????????file:??????
//*??????*??????????????????file???


