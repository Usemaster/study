package com.study.jwt;

import com.study.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil {
    //签名失效 60分
    private static Long failTime=1000L*60*60;
    //加密密文
    private static String key="kappy";


    /**
     * 生成token
     */
    public static String createJsonWebToken(User user){

        if(user==null || user.getId()==null||user.getUsername()==null){
            return null;
        }

        String token= Jwts.builder()
                .claim("id",user.getId())
                .claim("username",user.getUsername())
                .setIssuedAt(new Date())  //签发时间
                .setExpiration(new Date(System.currentTimeMillis()+failTime)) //失效时间
                .signWith(SignatureAlgorithm.HS256,key).compact();

        return token;

    }

    public static Claims checkJWT(String token ) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(key).
                    parseClaimsJws(token).getBody();
            return claims;

        } catch (Exception e) {
        }
        return null;

    }

    /**
     * 获取用户ID
     * @param
     * @return
     */
    public static Long getUserId(String token){
        Claims claims=JWTUtil.checkJWT(token);
        Integer id= (Integer) claims.get("id");
        return id.longValue();
    }


    /**
     * 校验用户名
     * @param
     */
    public static String getUserName(String token){
        Claims claims= JWTUtil.checkJWT(token);
        return (String) claims.get("username");
    }

//    public static void main(String [] a){
//        User user=new User();
//        user.setId(10L);
//        user.setUsername("kappy01");
//        String token=createJsonWebToken(user);
//        System.out.println(token);
//
//        //用户名
//        String name=getUserName(token);
//        System.out.println(name);
//        System.out.println(getUserId(token));
//    }


    /**
     * 验证token 获取用户对象
     */
    public static User getUser(String token){
        User user=new User();
        Long userId=getUserId(token);
        String username=getUserName(token);
        if(userId!=null && username!=null){
            user.setUsername(username);
            user.setId(userId);
        }
        return user;
    }

}
