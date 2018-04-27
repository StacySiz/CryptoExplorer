package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.models.User;
import ru.itis.services.AuthenticationService;

@Controller
public class SignInController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/signIn")
    public String showSignIn(Authentication authentication) {
        if (authentication!=null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            return "redirect:/profile";
        }

        return "signIn";
    }

    @PostMapping("/signIn")
    public String root(Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
        }

        return "redirect:/profile";
    }

}
