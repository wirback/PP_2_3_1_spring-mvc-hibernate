package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//    @GetMapping("/{id}")
//    public String getUserById(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "update";
//    }
    @GetMapping("/update")
    public String getUserById(@RequestParam Long id, Model model) {
        model.addAttribute("id", userService.getUserById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user) {
        System.out.println(user.getId() + " " + user.getName() + " " + user.getSurName());
        userService.updateUser(user);

        return "redirect:/";
    }

    @GetMapping("/new")
    public String add() {
        return "/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute User user) {
        userService.addUser(user);

        return "redirect:/";
    }
}
