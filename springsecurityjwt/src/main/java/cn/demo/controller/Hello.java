package cn.demo.controller;

import cn.demo.config.CustomUserDetails;
import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@RestController
public class Hello {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AuthenticationManager authenticationManager;
    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('book:read')")
    @RequestMapping("/demo")
    public String demo() {
        return "read";
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('book:write')")
    @RequestMapping("/demo2")
    public String demo2() {
        return "write";
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('book:delete')")
    @RequestMapping("/demo3")
    public String demo3() {
        return "delete";
    }

    @PostMapping("/login")
    public Map login(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = UsernamePasswordAuthenticationToken.unauthenticated(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        CustomUserDetails u = (CustomUserDetails) authentication.getPrincipal();
        int uid = u.getUid();
        Instant now = Instant.now();
        Instant t = now.plus(600, ChronoUnit.MINUTES);
        String token = JWT.create()
                .withClaim("id", uid)
                .withExpiresAt(t)
                .sign(Algorithm.HMAC256("123456"));
        redisTemplate.opsForValue().set("auth_" + uid, JSON.toJSONString(u.getUser()));
        return Map.of("code", 200, "token", token);
    }
}
