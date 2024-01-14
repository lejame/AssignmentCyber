package BT_20_12.Management.Filter;


import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpCookie;

import java.io.IOException;

public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookie = request.getCookies();
        for(Cookie cookie1 : cookie){
            if(cookie1.getAttribute("email")==null){
                response.sendRedirect(request.getContextPath()+"/login");
            }
            else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }
}
