package com.shenxian.config.security.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shenxian
 * @Date: 2021/7/23 10:49
 */
@Component
public class JwtTokenUtil {

    private static final String CLAIM_KEY_USERNAME = "sub";

    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 根据用户信息生成token
     *
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claim = new HashMap<>();
        claim.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claim.put(CLAIM_KEY_CREATED, new Date());

        return generateToken(claim);
    }

    /**
     * 根据token获取登录用户名
     *
     * @param token
     * @return
     */
    public String getUsernameByToken(String token) {
        String username;
        try {
            Claims claims = getClaimsByToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 校验token是否有效
     *
     * @param token
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameByToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否可以被刷新
     * @param token
     * @return
     */
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsByToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 判断token是否失效
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {
        Date date = getExpiredDateByToken(token);
        return date.before(new Date());
    }

    /**
     * 从token中获取过期时间
     * @param token
     * @return
     */
    private Date getExpiredDateByToken(String token) {
        Claims claims = getClaimsByToken(token);
        return claims.getExpiration();
    }

    /**
     * 从token中获取荷载
     *
     * @param token
     * @return
     */
    private Claims getClaimsByToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 根据负载生成token
     *
     * @param claim
     * @return
     */
    private String generateToken(Map<String, Object> claim) {
        return Jwts.builder()
                .setClaims(claim)
                .setExpiration(genetateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }

    /**
     * 生成token失效时间
     *
     * @return
     */
    private Date genetateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

}
