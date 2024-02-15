package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("userList", userService.getAllUsers());

        return "/users";
    }

    @GetMapping("/new")
    public String newUser() {
        return "/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute User user) {
        System.out.println(user.getName() + " " + user.getSurName());
        userService.addUser(user);

        return "redirect:/";
    }
}
