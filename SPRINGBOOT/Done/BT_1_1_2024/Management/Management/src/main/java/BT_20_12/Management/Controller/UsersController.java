package BT_20_12.Management.Controller;

import BT_20_12.Management.Entity.UsersEntity;
import BT_20_12.Management.Services.UsersService;
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
    public String login(Model model) {
        model.addAttribute("error","");
        return "login";
    }
    @GetMapping("/login_error")
    public String login_error(Model model){
        model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng. Vui lòng thử lại.");
        return "login";
    }
    @PostMapping("/login_action")
    public RedirectView form_login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        System.out.print(email + password);
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

}