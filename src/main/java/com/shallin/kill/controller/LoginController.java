package com.shallin.kill.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.shallin.kill.redis.RedisService;
import com.shallin.kill.service.MiaoshaUserService;
import com.shallin.kill.service.UserService;
import com.shallin.kill.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shallin.kill.result.Result;
import com.shallin.kill.vo.LoginVo;

/**
 * @author shallin
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info(loginVo.toString());
        //登录
        log.info(MD5Util.formPassToDBPass(loginVo.getPassword(),miaoshaUserService.getById(Long.parseLong(loginVo.getMobile())).getSalt()));
        miaoshaUserService.login(response, loginVo);
        return Result.success(true);
    }
//        public Result<Boolean> doLogin(
//                @RequestParam(value = "mobile",required = true) String mobile,
//                @RequestParam(value = "password",required = true) String password
//    ) {
//        log.info(mobile+password);
//        //登录
//        log.info(MD5Util.formPassToDBPass(password,miaoshaUserService.getById(Long.parseLong(mobile)).getSalt()));
////        miaoshaUserService.login(response, loginVo);
//        if(MD5Util.formPassToDBPass(password,miaoshaUserService.getById(Long.parseLong(mobile)).getSalt()) == miaoshaUserService.getById(Long.parseLong(mobile)).getPassword()) {
//            return Result.success(true);
//        }
//        return Result.success(true);
//    }
}
