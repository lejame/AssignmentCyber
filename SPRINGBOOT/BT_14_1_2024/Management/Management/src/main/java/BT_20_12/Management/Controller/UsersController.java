package BT_20_12.Management.Controller;


import BT_20_12.Management.Entity.RolesEntity;
import BT_20_12.Management.Entity.UsersEntity;
import BT_20_12.Management.Services.RoleService;
import BT_20_12.Management.Services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    public UsersService usersService;
    @Autowired
    private final RoleService roleService;

    public UsersController(RoleService roleService) {
        this.roleService = roleService;
    }

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
        List<UsersEntity> list_user = usersService.getAllUser();
        if(list_user.isEmpty()){
            return "user-table";
        }
        model.addAttribute("list_user",list_user);
        return "user-table";

    }

    @GetMapping("/form_add")
    public String formUserAdd(Model model) {
        List<String> countries = Arrays.asList("London", "India", "Usa", "Canada", "Thailand");
        List<RolesEntity> list_role = roleService.getRole();
        model.addAttribute("countries", countries);
        model.addAttribute("selectedCountry", "Usa");
        model.addAttribute("list_role", list_role);
        model.addAttribute("notice_check",false);
        model.addAttribute("notice_success",false);
        return "user-add";
    }
    // fix
    @PostMapping("/add_user")
    public String formUserAddSuccess(@RequestParam("full_name") String name,@RequestParam("email") String email,@RequestParam("password") String password,
                                           @RequestParam("phone") String phone,@RequestParam("country") String country,@RequestParam("role") String role,Model model){
        RolesEntity rolesEntity =  roleService.findRoleByName(role);

        if(rolesEntity==null){
            model.addAttribute("notice_check",true);
            return "user-add";
        }
        usersService.addnewMenber(name,email,password,phone,country,rolesEntity);
        model.addAttribute("notice_success",true);
        return "user-add";
    }
    @GetMapping("/edit")
    public String formEdit(){
        return "user-details";
    }
}