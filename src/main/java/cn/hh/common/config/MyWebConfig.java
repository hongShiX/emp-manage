package cn.hh.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier(value = "loginInterceptor")
    private HandlerInterceptor handlerInterceptor;
    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration
                = registry.addInterceptor(handlerInterceptor);

        // 拦截请求
        registration.addPathPatterns("/**");

        // 放行请求
        registration.excludePathPatterns(
                "/user/login",
                "/login",
                "/user/logout",
                "/layui/**",
                "/lib/**",
                "/webjars/**",
                "/captcha",
                "/api/**",
                "/css/**",
                "/js/**",
                "/images/**"
        );
    }
}
