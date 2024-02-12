package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getAllUsers(ModelMap model, @RequestParam(required = false, defaultValue = "0") Integer id) {
    public String getAllUsers(ModelMap model) {
//        Optional<UserService> opt = Optional.ofNullable(userService.getAllUsers());
//        model.addAllAttributes(Optional.ofNullable(userService.getAllUsers()).orElse(new ));
        model.addAllAttributes(userService.getAllUsers());
        return "users";
    }
}
