package BT_20_12.Management.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("kiem tra filter");
        HttpServletRequest Request = (HttpServletRequest) servletRequest;
        HttpServletResponse Response = (HttpServletResponse) servletResponse;
        HttpSession session = Request.getSession();

        // kiem tra session co ton tai hay không;
        if (session.getAttribute("email") != null && session != null && session.getAttribute("email").equals("")) {
            // chuyển hướng về trang chủ
            session.setMaxInactiveInterval(8*60*60);
            Response.sendRedirect("/home");

        } else {
            // cho di tiep vao duong dan client dang goi hoac thoat khoi filter va di tiep
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }
}
