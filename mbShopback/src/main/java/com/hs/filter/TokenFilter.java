package com.hs.filter;

import com.hs.entity.Token;
import com.hs.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class TokenFilter implements Filter {
    private TokenService tokenService;
    @Override
    public void init(FilterConfig filterConfig) {
        ServletContext context = filterConfig.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        tokenService = (TokenService) ctx.getBean(TokenService.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String tokenString = req.getHeader("token");
        String respToken = "";

        //没有token（第一次请求）
        if (tokenString == null){
            Token token = new Token();
            token.setTVal(UUID.randomUUID().toString());
            System.out.println(token.getTVal());
            tokenService.insert(token);
        } else {//第二次请求
            //验证token是否过期
            Token token = tokenService.selectByUUID(tokenString);
            if(token==null){
                //            重新生成token（新会话）
                token=new Token();
                token.setTVal(UUID.randomUUID().toString());
                tokenService.insert(token);
            }

            respToken=token.getTVal();
        }
        req.setAttribute("token",respToken);
        resp.setHeader("token",respToken);
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
