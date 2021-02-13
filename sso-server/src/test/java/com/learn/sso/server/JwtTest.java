package com.learn.sso.server;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtTest
{
    private static final byte[] SIGN_KEY = "hello world".getBytes(StandardCharsets.UTF_8);

    /**
     * 单元测试用例
     * 生成jwtToken
     */
    @Test
    public void jwtTest1(){
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("phone","154****11234");
        objectMap.put("username","wuyusen");
        objectMap.put("age",18);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(objectMap)
                .setExpiration(new Date())
                .signWith(SignatureAlgorithm.HS256,SIGN_KEY);
        System.out.println(jwtBuilder.compact());
    }
}
