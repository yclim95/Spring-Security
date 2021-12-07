package com.knowyourneighborhood;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value="/login",  method= RequestMethod.GET)
    public String onLogin() {
        return "login";
    }

    @RequestMapping(value="/login_error")
    public String onLoginError(Model model) {
        String error_msg = "Incorrect user or password. Please re-enter.";
        model.addAttribute("error_string", error_msg);
        return "login";
    }
}
