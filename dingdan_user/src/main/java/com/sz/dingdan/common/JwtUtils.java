package com.sz.dingdan.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

//工具类：创建一个签证，及解析一个签证；
@Component
public class JwtUtils {

    private static  String id = "zhiling";
    private static  long ttl = 900000;   //有交期为15分钟；

    //创建一个签证，
    public  String  createJwt(String subject, String roles){
            long t = System.currentTimeMillis();
            Date dt = new Date(t);   //发签证的时间；
            Date date = new Date(t+ttl);  //过期的时间；
        JwtBuilder jb = Jwts.builder().setId(id).setIssuedAt(dt).setExpiration(date)
                .setSubject(subject).signWith(SignatureAlgorithm.HS256,id).claim("roles",roles);
        String  s = jb.compact();
        return s;
    }


    //解析签证：
    public  Claims parseToken(String token){
        //eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ6aGlsaW5nIiwiaWF0IjoxNTk5NDQ2MzYwLCJleHAiOjE1OTk0NDk5NjAsInN1YiI6IuWIoOmZpOWfjuW4gueahOWKn-iDvSIsInJvbGVzIjoiZGVsZXRlUm9sZXMifQ.wkjQBoKJd_fhQWQKe2DRc3fDZ1wT_kxKATEr_ma3fq4
        Claims claims = Jwts.parser().setSigningKey(id).parseClaimsJws(token).getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());  //删除城市的功能
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.getExpiration());
        System.out.println(claims.get("roles"));   //deleteRoles
        return claims;
    }



    //测试：
    public static void main(String[] args) {
        //System.out.println(createJwt("删除城市的功能","deleteRoles"));
        //String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ6aGlsaW5nIiwiaWF0IjoxNTk5NDQ2MzYwLCJleHAiOjE1OTk0NDk5NjAsInN1YiI6IuWIoOmZpOWfjuW4gueahOWKn-iDvSIsInJvbGVzIjoiZGVsZXRlUm9sZXMifQ.wkjQBoKJd_fhQWQKe2DRc3fDZ1wT_kxKATEr_ma3fq4";
        //Claims c = parseToken(token);
    }
}
