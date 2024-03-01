package com.yry.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static final String SECRET_KEY = "JwtPASS"; // 密钥，请替换为您自己的密钥
    private static final long EXPIRATION_TIME = 86400000; // 过期时间为24小时

    /**
     * 生成JWT
     *
     * @param subject JWT的主题
     * @return 生成的JWT字符串
     */
    public static String generateJwtToken(String subject) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * 验证JWT的有效性
     *
     * @param jwtToken JWT字符串
     * @return 如果JWT有效，则返回true；否则返回false
     */
    public static boolean validateJwtToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken);
            return true;
        } catch (Exception e) {
            // Token验证失败
        }
        return false;
    }

    /**
     * 从JWT中获取用户名（主题）
     *
     * @param jwtToken JWT字符串
     * @return 提取的用户名
     */
    public static String getUsernameFromJwtToken(String jwtToken) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken);
        return claims.getBody().getSubject();
    }
}

