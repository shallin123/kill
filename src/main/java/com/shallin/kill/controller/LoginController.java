package com.shallin.kill.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.shallin.kill.redis.RedisService;
import com.shallin.kill.service.MiaoshaUserService;
import com.shallin.kill.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shallin.kill.result.Result;
import com.shallin.kill.vo.LoginVo;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MiaoshaUserService miaoshaUserService;

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
}
