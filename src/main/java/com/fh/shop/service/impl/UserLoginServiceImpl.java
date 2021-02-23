package com.fh.shop.service.impl;

import com.fh.shop.dao.UserLoginDao;
import com.fh.shop.entity.po.Menu;
import com.fh.shop.entity.po.User;
import com.fh.shop.service.UserLoginService;
import com.fh.shop.utils.JWT;
import com.fh.shop.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    private UserLoginDao userLoginDao;

    @Resource
    private HttpSession session;

    @Override
    public Map addUser(User user) {
        Map map=new HashMap();
       User user1= userLoginDao.selectUserByName(user.getName());
       if(user1==null){
           String newPassword = MD5Util.encoder(user.getPassword());
           user.setPassword(newPassword);
           Date da=new Date();
           user.setCreateDate(da);
           user.setUpdateDate(da);
           userLoginDao.addUser(user);
           map.put("code",1);
       }else{
           map.put("code",2);
       }
        return map;
    }

    @Override
    public Map toLoginUser(String name, String password) {
        Map map=new HashMap();
        User user1= userLoginDao.selectUserByName(name);
        if(user1!=null){
            String newPassword = MD5Util.encoder(password);
            if(user1.getPassword().equals(newPassword)){
                map.put("code",3);//密码正确
                String sign = JWT.sign(user1, 180);

                //将token信息进行base64加密  得到加密类
                Base64.Encoder encoder = Base64.getEncoder();
                //设置加密信息 字节数组
                byte[] userInfo=(name+"liudi"+sign).getBytes();
                //加密密文
                byte[] encode = encoder.encode(userInfo);
                //将字节数组 转为字符串
                String tokenInfo=new String(encode);
                map.put("token",tokenInfo);
            }else{
                map.put("code",2);//密码不正确
            }
        }else{
            map.put("code",1);//用户不存在
        }
        return map;
    }

    @Override
    public List<Menu> selectUserMeunData(String name) {
        User user1= userLoginDao.selectUserByName(name);
        List<Menu>list=userLoginDao.selectUserMeunData(user1.getId());

        return list;
    }


}
