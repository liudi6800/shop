package com.fh.shop.Inteceptors;

import com.alibaba.fastjson.JSONObject;
import com.fh.shop.entity.po.User;
import com.fh.shop.utils.JWT;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginInteceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        String token = request.getParameter("token");
        if(token==null){
            Map rs=new HashMap();
            rs.put("code",600);
            rs.put("data"," que shao  token");
            //响应请求 返回json字符串信息
            response.getWriter().write(JSONObject.toJSONString(rs));
            return  false;
        }


        // 验证token  1 得到token
        //解密
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(token);
        String tokenStr=new String(decode); // name+1111+token
        //得到name 和token
        String[] liudi = tokenStr.split("liudi");
        if(liudi.length!=2){
            // 响应此次请求
            Map rs=new HashMap();
            rs.put("code",600);
            rs.put("data"," fei fa   token");
            //响应请求 返回json字符串信息
            response.getWriter().write(JSONObject.toJSONString(rs));
            return false;
        }

        //认证token信息是否正确
        User user = JWT.unsign(liudi[1], User.class);
        if(user==null){//没验证过  需要拦截
            Map rs=new HashMap();
            rs.put("code",600);
            rs.put("data","token is error");
            //响应请求 返回json字符串信息
            response.getWriter().write(JSONObject.toJSONString(rs));
            return  false;
        }

        return true;
    }


}
