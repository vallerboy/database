package pl.oskarpolak.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.database.models.EmailModel;
import pl.oskarpolak.database.models.forms.EmailForm;
import pl.oskarpolak.database.models.repositories.EmailRepostiory;
import pl.oskarpolak.database.models.services.EmailService;

/**
 * Created by Lenovo on 04.09.2017.
 */
@Controller
public class MainController {

    @Autowired
    EmailRepostiory emailRepostiory;

    @Autowired
    EmailService emailService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("formEmail", new EmailForm());
        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("formEmail") EmailForm form, Model model){
        EmailModel emailModel = new EmailModel(form);
        emailRepostiory.save(emailModel);
        emailService.sendEmail(emailModel);

        model.addAttribute("message", "Wiadomość został wysłana. ");

        return "index";
    }

    @GetMapping("/getall")
    @ResponseBody
    public String getAllEmails() {
        StringBuilder builder = new StringBuilder();
        for (EmailModel emailModel : emailRepostiory.findAll()) {
            builder.append(emailModel.toString());
            builder.append("<br>");
        }
        return builder.toString();
    }

    @GetMapping("/user/{user}")
    @ResponseBody
    public String getUser(@PathVariable("user") String user){
        StringBuilder info = new StringBuilder();
        info.append("Ostatni email: " + emailRepostiory.findFirstByAuthorStartingWithOrderByDateDesc(user).toString());
        info.append("<br>");
        info.append("Ilość wysłanych maili: " + emailRepostiory.findByAuthorStartingWith(user).size());
        System.out.println(user);
        return info.toString();
    }


}

