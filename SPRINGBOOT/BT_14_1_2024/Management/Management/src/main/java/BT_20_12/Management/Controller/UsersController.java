package BT_20_12.Management.Controller;


import BT_20_12.Management.Services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    public UsersService usersService;

    @GetMapping("/profile_user")
    public String profileUser(Model model) {
        return "profile";
    }

    @GetMapping("/profile_user_edit")
    public String profileUserEdit(Model model) {
        return "profile-edit";
    }

    @GetMapping("/form_user")
    public String formUser(Model model) {
        return "user-table";
    }

    @GetMapping("/form_add")
    public String formUserAdd() {
        return "user-add";
    }
    // fix
    @PostMapping("/add_user")
    public RedirectView formUserAddSuccess(@RequestParam("full_name") String name,@RequestParam("email") String email,@RequestParam("password") String password,
                                           @RequestParam("phone") String phone){
        return new RedirectView("/form_add");
    }
}