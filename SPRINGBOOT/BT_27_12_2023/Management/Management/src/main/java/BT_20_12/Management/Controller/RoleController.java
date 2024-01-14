package BT_20_12.Management.Controller;

import BT_20_12.Management.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    public RoleService roleService;

    @GetMapping("/form_role_table")
    public String role_table(Model model){
        model.addAttribute("role_information",roleService.getListRole());
        return "role-table";
    }
    @GetMapping("/form_add")
    public String form_add(){
        return "role-add";
    }
    @PostMapping("/add")
    public String add(@RequestParam("name_role")String name, @RequestParam("description") String description, Model model){
        boolean isSuccess =  roleService.saveNewRoles(name,description);
        if(isSuccess){
            model.addAttribute("isSuccess",isSuccess);
            return "role-add";
        }

        model.addAttribute("isFail",isSuccess);
        return "role-add";
    }
}
