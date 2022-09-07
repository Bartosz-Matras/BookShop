package pl.matrasbartosz.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.matrasbartosz.bookshop.model.UserDTO;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model theModel){
        theModel.addAttribute("user", new UserDTO());
        return "login-form";
    }

}
