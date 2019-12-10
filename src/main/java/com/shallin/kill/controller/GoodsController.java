package com.shallin.kill.controller;

import com.shallin.kill.entity.MiaoshaUser;
import com.shallin.kill.redis.RedisService;
import com.shallin.kill.service.MiaoshaUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_list")
    public String toLogin(Model model, MiaoshaUser miaoshaUser) {
//        if(StringUtils.isEmpty(cookieToken)&&StringUtils.isEmpty(paramToken)){
//            return "login";
//        }
//        String token = StringUtils.isEmpty(paramToken)? cookieToken:paramToken;
//        MiaoshaUser miaoshaUser = miaoshaUserService.getByToken(response,token);
//        model.addAttribute("user",miaoshaUser);
        model.addAttribute("user",miaoshaUser);
        return "goods_list";
    }


}
