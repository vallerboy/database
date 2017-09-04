package pl.oskarpolak.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.oskarpolak.database.models.repositories.EmailRepostiory;

/**
 * Created by Lenovo on 04.09.2017.
 */
@Controller
public class LoginController {


    @Autowired
    EmailRepostiory emailRepostiory;

    @GetMapping("/admin")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("password") String password,  Model model) {
        if (password.equals("tajnehaslo")) {
            model.addAttribute("emails", emailRepostiory.findAll());
            return "admin";
        }
        return "login";
    }
}
