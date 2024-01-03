package BT_20_12.Management.Controller;

import BT_20_12.Management.Entity.UsersEntity;
import BT_20_12.Management.Services.UsersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/login")
    public String login(HttpServletResponse httpServletResponse, Model model) {
        model.addAttribute("error","");
        Cookie cookie = new Cookie("hello", URLEncoder.encode("dang nhap di", StandardCharsets.UTF_8));

        httpServletResponse.addCookie(cookie);
        return "login";
    }
    @GetMapping("/login_error")
    public String login_error(Model model){
        model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng. Vui lòng thử lại.");
        return "login";
    }
    @PostMapping("/login_action")
    public RedirectView form_login(HttpSession httpSession, @RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        UsersEntity user = usersService.getUsersEntityByEmailAndAndPassword(email, password);
        if (user == null) {
            return new RedirectView("/login_error");
        }
        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public String Home() {
        return "index";
    }


    // sử dụng cookie và session hoặc là database để lưu lại thông tin của client

    @GetMapping("/profile_user")
    public String profileUser(Model model){
        return "profile";
    }

    @GetMapping("/profile_user_edit")
    public String profileUserEdit(Model model){
        return "profile-edit";
    }

}