package BT_20_12.Management.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request  = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getServletPath();

        System.out.println(path);

        HttpSession session = request.getSession();
        // o day chua xu ly
        if(session != null && session.getAttribute("email") != null && !session.getAttribute("email").equals("")){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            if(path.equals("/login")) {
                filterChain.doFilter(servletRequest,servletResponse);
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }

        }
    }
}
