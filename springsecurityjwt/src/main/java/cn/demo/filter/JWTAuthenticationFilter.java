package cn.demo.filter;

import cn.demo.config.CustomUserDetails;
import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        JWTVerifier vfy = JWT.require(Algorithm.HMAC256("123456")).build();
        DecodedJWT res;
        System.out.println("jwt验证...");
        try {
            res = vfy.verify(token);
            Claim id = res.getClaim("id");
            String userJson = redisTemplate.opsForValue().get("auth_" + id);
            CustomUserDetails.User user = JSON.parseObject(userJson, CustomUserDetails.User.class);
            if (!Objects.isNull(user)) {
                List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(user.getAuthorities());
                // 生成一个已认证状态的Authentication
                UsernamePasswordAuthenticationToken authentication = UsernamePasswordAuthenticationToken.authenticated(user.getUsername(), null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (JWTVerificationException e) {
            System.out.println("jwt验证错误" + e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
