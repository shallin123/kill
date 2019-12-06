package com.shallin.kill.service;

import com.shallin.kill.dao.MiaoshaDao;
import com.shallin.kill.entity.MiaoshaUser;
import com.shallin.kill.exception.GlobalException;
import com.shallin.kill.result.CodeMsg;
import com.shallin.kill.util.MD5Util;
import com.shallin.kill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shallin
 */
@Service
public class MiaoshaService {
    @Autowired
    MiaoshaDao miaoshaDao;
    public MiaoshaUser getById(long id) {
        return miaoshaDao.getById(id);
    }
    public boolean login(LoginVo loginVo){
        if(loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
        MiaoshaUser user = getById(Long.parseLong(mobile));
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPasstoDBPass(formPass, saltDB);
        if(!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        return true;
    }
}
