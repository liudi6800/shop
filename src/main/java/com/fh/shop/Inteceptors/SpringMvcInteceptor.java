package com.fh.shop.Inteceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringMvcInteceptor implements WebMvcConfigurer {




    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration kuayu = registry.addInterceptor(new KuaYuInteceptor());

        //设置拦截路径
        kuayu.addPathPatterns("/**");




        //注册TestInterceptor拦截器
        InterceptorRegistration zuce = registry.addInterceptor(new LoginInteceptor());

        //设置拦截的路径
        zuce.addPathPatterns("/**");                      //所有路径都被拦截
        //设置不拦截的路径
        zuce.excludePathPatterns("/api/userLogin/*");


    }



}
