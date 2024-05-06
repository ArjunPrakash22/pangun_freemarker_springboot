package com.example.demo.controllers;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;

@Controller
public class TestController {

    private final UserService userService;

    @Autowired
    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/welcome")
    public String welcome(Model model, @RequestParam(value = "username", required = false) String username) {
        model.addAttribute("username", username);
        return "welcome";
    }

    @GetMapping("/")
    public String login(Model model,
                        @RequestParam(value = "Login", required = false, defaultValue = "LOGIN") String login,
                        @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("login", login);
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model, @RequestParam(value = "register", required = false, defaultValue = "SIGN UP") String name) {
        model.addAttribute("register", name);
        return "register";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @RequestParam(value = "username", required = false) String username) {
        model.addAttribute("username", username);
        return "dashboard";
    }

    @PostMapping("/")
    public ModelAndView processLoginForm(@RequestParam("username") String username,
                                         @RequestParam("password") String password) {
        // Here you would typically validate the username and password
        // against your database or some other authentication mechanism.
        // For demonstration purposes, let's assume a simple check.
        System.out.println(username);
        System.out.println(password);
        String user1 = username.trim();
        String storedpswd = userService.getPasswordByUsername(user1);
        System.out.println(storedpswd);
        if (storedpswd != null && storedpswd.equals((password))) {
//        if ("arjun".equals(username) && "arjun".equals(password)) {
            // Authentication successful, redirect to dashboard with username parameter
            ModelAndView modelAndView = new ModelAndView("redirect:/dashboard");
            modelAndView.addObject("username", username);
            return modelAndView;
        } else {
            // Authentication failed, return the login page with an error message
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("error", "Invalid username or password");
            return modelAndView;
        }
    }

    @PostMapping("/register")
    public ModelAndView processRegistrationform(@RequestParam("name") String name,
                                                @RequestParam("username") String username,
                                                @RequestParam("mobile") String mobile,
                                                @RequestParam("mailid") String mailId,
                                                @RequestParam("password") String password) {
        User newUser = new User();
        newUser.setFullName(name);
        newUser.setUsername(username);
        newUser.setMobile(mobile);
        newUser.setMailId(mailId);
        newUser.setPassword(password);
System.out.println(name);
        // Save the new user to the database
        userService.saveUser(newUser);

        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("username", username);
        return modelAndView;
    }
}

