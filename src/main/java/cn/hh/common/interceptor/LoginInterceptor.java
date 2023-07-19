package cn.hh.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j // 打日志
@Component("loginInterceptor")
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断session，判断session里面的用户是否存在
        Object user = request.getSession().getAttribute("userInfo");
        if (user == null) {
            // 未登录，就跳转到登陆页面
            log.debug("未登录请求：" + request.getRequestURI());
            response.sendRedirect(request.getContextPath() + "/login");
            return false;  // 拦截
        }
        log.debug("放行请求：" + request.getRequestURI());
        return true;  // 放行
    }
}
