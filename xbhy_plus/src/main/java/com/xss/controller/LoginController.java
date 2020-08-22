package com.xss.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xss.entity.Result;
import com.xss.entity.User;
import com.xss.service.UserService;
import com.xss.utils.MDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @author XSS
 * @date 2020/8/13
 * @desc
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService service;

    @Autowired
    HttpServletRequest req;

    @RequestMapping("login")
    @ResponseBody
    public Result toLogin(String username, String password, String code, Boolean remember, @SessionAttribute("checkCode") String checkCode, HttpSession session, HttpServletResponse resp) throws JsonProcessingException, UnsupportedEncodingException {
        ObjectMapper om = new ObjectMapper();
        Cookie[] cookies = req.getCookies();
        User user = new User();
        user.setUsername(username);
        user.setPassword(MDUtil.md5(password));

        User one = service.selectOne(user);
        if (checkCode.equals(code)) {
            if (one != null) {
                if (remember) {
                    Cookie cookie = new Cookie("LoginUserCookie", URLEncoder.encode(om.writeValueAsString(one), "utf-8"));
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    cookie.setPath("/");
                    resp.addCookie(cookie);
                }

                one.setLoginTime(new Date());
                service.updateByPrimaryKeySelective(one);

                one.setPassword(null);
                session.setAttribute("loginUser", one);
                return new Result(true, "登陆成功", one);
            }
        }

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("LoginUserCookie".equals(cookie.getName())) {
                    String value = cookie.getValue();

                    //将cookie中的值给进session中
                    value = URLDecoder.decode(value, "utf-8");
                    User LoginOne = om.readValue(value, User.class);
                    session.setAttribute("loginUser", LoginOne);
                    return new Result(true, "登陆成功", LoginOne);
                }
            }
        }

        return new Result(false, "账号密码或者验证码错误", null);
    }

    @RequestMapping("toHome")
    public ModelAndView toHome() {
        return new ModelAndView("home");
    }

    @RequestMapping("loginOut")
    public String loginOut(HttpSession session, HttpServletResponse resp) {
        session.invalidate();

        Cookie[] cookies = req.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = new Cookie("LoginUserCookie", null);
            cookie.setMaxAge(0);

            // 根据你创建cookie的路径进行填写
            cookie.setPath("/");

            resp.addCookie(cookie);
        }

        return "redirect:/index.html";
    }
}
