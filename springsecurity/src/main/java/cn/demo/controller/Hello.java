package cn.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }

    @ResponseBody
    @PreAuthorize("hasRole('AAA')")
    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }

    @ResponseBody
    @PreAuthorize("hasAnyRole('BBB','CCC')")
    @RequestMapping("/demo2")
    public String demo2() {
        return "demo";
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('book:read')")
    @RequestMapping("/demo3")
    public String demo3() {
        return "read";
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('book:write')")
    @RequestMapping("/demo4")
    public String demo4() {
        return "write";
    }

    @ResponseBody
    @PreAuthorize("hasAuthority('book:delete')")
    @RequestMapping("/demo5")
    public String demo5() {
        return "delete";
    }

    @GetMapping("/login")
    public String login() {
        return "login_page";
    }


    @PostMapping("/login2")
    @ResponseBody
    public String login2(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(username, password);
        System.out.println("开始验证");
        Authentication authentication = authenticationManager.authenticate(token);
        System.out.println("验证结果: " + authentication.isAuthenticated());
        SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
        SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextHolderStrategy.setContext(context);
        securityContextRepository.saveContext(context, request, response);
        return "ok";
    }

}
