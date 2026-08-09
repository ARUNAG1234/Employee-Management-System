package com.aruna.employeemanagement.controller;

import com.aruna.employeemanagement.entity.User;
import com.aruna.employeemanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        if (userService.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }

        userService.register(user);

        return "redirect:/login?registered";
    }
}
