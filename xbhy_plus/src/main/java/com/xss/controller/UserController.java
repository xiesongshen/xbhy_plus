package com.xss.controller;

import com.xss.entity.Result;
import com.xss.entity.User;
import com.xss.service.UserService;
import com.xss.utils.EmailUtil;
import com.xss.utils.MDUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author XSS
 * @date 2020/8/14
 * @desc
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService service;

    @Value("${path}")
    private String path;

    @Value("${realPath}")
    private String realPath;


    @RequestMapping("toUser")
    public ModelAndView toUser() {
        return new ModelAndView("user");
    }

    @RequestMapping(value = "selectPage/{pageNum}/{pageSize}")
    public Result selectPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, String username) {

        return new Result(true, "查询成功", service.selectPage(pageNum, pageSize, username));
    }


    @RequestMapping("toDetail")
    public ModelAndView toDetail() {
        return new ModelAndView("user_detail");
    }

    @RequestMapping("count")
    public Result count() {
        return new Result(true, "查询成功", service.userCount());
    }

    @RequestMapping("toUserFocus")
    public ModelAndView toUserFocus() {
        return new ModelAndView("my_user");
    }

    @RequestMapping("selectFocus/{pageNum}/{pageSize}")
    public Result selectFocus(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, Integer id) {
        return new Result(true, "查询成功", service.selectFocus(pageNum, pageSize, id));
    }

    @RequestMapping("addLook")
    public Result addLook(@RequestBody User user) {
        if (user.getLook() == null) {
            user.setLook(1);
        } else {
            Integer look = user.getLook();
            look++;
            user.setLook(look);
        }
        return new Result(true, "成功", service.addLook(user));
    }


    @RequestMapping("selectF")
    public Result selectF(Integer id) {
        return new Result(true, "成功", service.selectFocus(id));
    }


    @RequestMapping("selectUserByDid")
    public Result selectUserByDid(Integer id) {
        User user = new User();
        user.setDeptId(id);
        return new Result(true, "查询成功", service.select(user));
    }

    @RequestMapping("selectFocusByid")
    public Result selectFocusByid(Integer id) {
        return new Result(true, "成功", service.selectFocusByid(id));
    }

    @RequestMapping("selectMyUserSc")
    public Result selectMyUserSc(Integer aid, Integer uid) {
        return new Result(true, "成功", service.selectMyUserSc(aid, uid));
    }

    @RequestMapping("toUpdate")
    public ModelAndView toUpdate() {
        return new ModelAndView("user_update");
    }

    @RequestMapping("doUpdate")
    public Result doUpdate(@RequestBody User user) {
        service.updateByPrimaryKeySelective(user);
        User u = new User();
        u.setId(user.getId());
        return new Result(true, "成功", service.selectOne(u));
    }


    @RequestMapping(value = "uploadImg", method = RequestMethod.POST)
    public String uploadImg(@RequestParam(value = "file") MultipartFile file, HttpSession session) {
        String result = null;

        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        String type = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID() + type;

        try {
            file.transferTo(new File(realPath, fileName));
            Map<String, Object> success = resultMap("SUCCESS", originalFilename, file.getSize(), fileName, type, path + fileName);

            result = new JSONObject(success).toString();
        } catch (IOException e) {
            result = new JSONObject(resultMap("FAIL", null, 0, null, null, null)).toString();
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "email")
    public Result sendEmail(String email, HttpSession session) {
        if (!StringUtils.isEmpty(email)) {
            String randomCode = Math.random() + "";
            randomCode = randomCode.substring(randomCode.length() - 5, randomCode.length() - 1);
            boolean b = EmailUtil.sendEmail(email, randomCode);

            if (b) {
                //把验证码放到session中
                session.setAttribute("FORGRT_SESSION", randomCode);
                session.setMaxInactiveInterval(60);
                return new Result(true, "成功", null);
            }
        }

        return new Result(false, "不成功", null);
    }


    @RequestMapping("updatePassord")
    public Result updatePassord(String email, String code, String password, HttpSession session) {
        User user = new User();
        user.setEmail(email);
        User one = service.selectOne(user);

        Object forgetCode = session.getAttribute("FORGRT_SESSION");

        if (code != null) {
            if (one != null && forgetCode.equals(code)) {

                one.setPassword(MDUtil.md5(password));
                return new Result(true, "修改成功", service.updateByPrimaryKeySelective(one));
            } else {
                return new Result(false, "请输入正确信息", null);
            }
        } else {
            return new Result(false, "请输入验证码", null);
        }
    }

    @RequestMapping("doInsert")
    public Result doInsert(@RequestBody User user) {

        user.setPassword(MDUtil.md5(user.getPassword()));


        return new Result(true, "注册成功", service.insertSelective(user));
    }


    //{"state": "SUCCESS","original": "111.jpg","size": "124147","title": "1535961757878095151.jpg","type": ".jpg","url": "/1535961757878095151.jpg"}
    private Map<String, Object> resultMap(String state, String original, long size, String title, String type, String url) {
        Map<String, Object> result = new HashMap<>();
        result.put("state", state);
        result.put("original", original);
        result.put("size", size);
        result.put("title", title);
        result.put("type", type);
        result.put("url", url);
        return result;
    }

}
