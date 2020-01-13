package com.shallin.kill.controller;

import com.shallin.kill.entity.MiaoshaUser;
import com.shallin.kill.redis.RedisService;
import com.shallin.kill.service.GoodsService;
import com.shallin.kill.service.MiaoshaUserService;
import com.shallin.kill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;
//    @RequestMapping("/to_list")
//    public String totest(Model model, MiaoshaUser miaoshaUser) {
////        if(StringUtils.isEmpty(cookieToken)&&StringUtils.isEmpty(paramToken)){
////            return "login";
////        }
////        String token = StringUtils.isEmpty(paramToken)? cookieToken:paramToken;
////        MiaoshaUser miaoshaUser = miaoshaUserService.getByToken(response,token);
////        model.addAttribute("user",miaoshaUser);
//        model.addAttribute("user",miaoshaUser);
//        List<GoodsVo> goodsList = goodsService.listGoodsVo();
//        model.addAttribute("goodsList",goodsList);
//        return "goods_list";
//    }
    @RequestMapping("/to_list")
    public String toLogin(Model model, MiaoshaUser miaoshaUser) {
//        if(StringUtils.isEmpty(cookieToken)&&StringUtils.isEmpty(paramToken)){
//            return "login";
//        }
//        String token = StringUtils.isEmpty(paramToken)? cookieToken:paramToken;
//        MiaoshaUser miaoshaUser = miaoshaUserService.getByToken(response,token);
//        model.addAttribute("user",miaoshaUser);
        model.addAttribute("user",miaoshaUser);
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList",goodsList);
        return "goods_list";
    }

    @RequestMapping("/to_detail/{goodsId}")
    public String detail(Model model, MiaoshaUser miaoshaUser,
                         @PathVariable("goodsId")long goodsId){
        //snowsflakes算法
        model.addAttribute("user", miaoshaUser);
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goods);
        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();
        int miaoshaStatus = 0;
        int remainSeconds = 0;
        if(now <startAt){
            //倒计时
            miaoshaStatus = 0;
            remainSeconds = (int) ((startAt - now)/1000);
        }else if (now > endAt) {
            miaoshaStatus = 2;
            remainSeconds = -1;
        }else{
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "goods_detail";
    }

}
