package cn.hh.user.controller;

import cn.hh.common.vo.Result;
import cn.hh.user.entity.User;
import cn.hh.user.service.UserService;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(User user, @RequestParam("captcha") String captcha, HttpServletRequest request, HttpServletResponse response) {
        String remember = request.getParameter("remember");
        // 验证码判断
        if (!CaptchaUtil.ver(captcha, request)) {
            CaptchaUtil.clear(request);
            return Result.fail("验证码错误！");
        }
        HttpSession session = request.getSession(true);
        User login = userService.login(user);
        if (login != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            // 参数1是请求密码，参数2是数据库中加密的值
            boolean matches = passwordEncoder.matches(user.getPassword(), login.getPassword());

            if (matches) {
                if (remember != null) {
                    Cookie userCookie = new Cookie("username", user.getUsername());
                    Cookie passwordCookie = new Cookie("password", user.getPassword());
                    userCookie.setMaxAge(60 * 60 * 24 * 10);
                    passwordCookie.setMaxAge(60 * 60 * 24 * 10);
                    response.addCookie(userCookie);
                    response.addCookie(passwordCookie);
                    session.setAttribute("username", user.getUsername());
                    session.setAttribute("password", user.getPassword());
                }
                login.setPassword(null);  // 安全起见，把用户传入session之前先把password设置为null
                session.setAttribute("userInfo", login);
                // 登录成功
                return Result.success();
            }
        }

        // 登录失败
        return Result.fail("用户名或密码错误");
    }
}
