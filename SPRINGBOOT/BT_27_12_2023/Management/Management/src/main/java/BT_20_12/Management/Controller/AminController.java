package BT_20_12.Management.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AminController {
    @GetMapping("/error")
    public String Error_404(){
        return "404";
    }
}
