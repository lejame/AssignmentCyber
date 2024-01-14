package BT_20_12.Management.Controller;

import BT_20_12.Management.Entity.UsersEntity;
import BT_20_12.Management.Services.UsersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        model.addAttribute("error", "");
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return "login";
        }
        String email = "";
        String pass = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("email")) {
                email = cookie.getValue();
            }
            if (cookie.getName().equals("password")) {
                pass = cookie.getValue();
            }
        }
        model.addAttribute("email", email);
        model.addAttribute("password", pass);
        return "login";

    }

    @GetMapping("/login_error")
    public String login_error(Model model) {
        model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng. Vui lòng thử lại.");
        return "login";
    }

    @PostMapping("/login_action")
    public RedirectView form_login(HttpServletResponse httpServletResponse, HttpSession httpSession, @RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        UsersEntity user = usersService.getUsersEntityByEmailAndAndPassword(email, password);
        if (user == null) {
            return new RedirectView("/login_error");
        }
        Cookie cookie_email = new Cookie("email", email);
        Cookie cookie_password = new Cookie("password", password);
        System.out.println(cookie_password.toString());
        httpServletResponse.addCookie(cookie_email);
        httpServletResponse.addCookie(cookie_password);

        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public String Home() {
        return "index";
    }


    // sử dụng cookie và session hoặc là database để lưu lại thông tin của client

    @GetMapping("/profile_user")
    public String profileUser(Model model) {
        return "profile";
    }

    @GetMapping("/profile_user_edit")
    public String profileUserEdit(Model model) {
        return "profile-edit";
    }

}