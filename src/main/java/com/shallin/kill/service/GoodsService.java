package com.shallin.kill.service;

import com.shallin.kill.dao.GoodsDao;
import com.shallin.kill.dao.UserDao;
import com.shallin.kill.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shallin
 */
@Service
public class GoodsService {
   @Autowired
   GoodsDao goodsDao;

}
