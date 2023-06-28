package com.IEC.SGCDOCS.securingweb.config;

import com.IEC.SGCDOCS.SgcDocsApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/home").setViewName("home");

        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/docs-emitidos.html").setViewName("docs-emitidos");
        registry.addViewController("/cliente1.html").setViewName("cliente1");
        registry.addViewController("/cliente2.html").setViewName("cliente2");
        registry.addViewController("/cliente3.html").setViewName("cliente3");
        registry.addViewController("/files/").setViewName("/media/files/");
//        registry.addViewController("/static-docs/").setViewName("/static-docs/");
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.addViewController("").setViewName("forward:/index.html");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        registry
                .addResourceHandler("/static-docs/**")
//                .addResourceLocations("file:///D:/TEMP/");
                .addResourceLocations(SgcDocsApplication.conf.getResource1Location());
    }

}