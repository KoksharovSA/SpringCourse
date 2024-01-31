package ru.gb.SpringCourseL1.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.SpringCourseL1.model.User;
import ru.gb.SpringCourseL1.service.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
@Log
public class UserController {
    private final UserService userService;
    @GetMapping("/users")
    public String findAll(Model model){
        log.info("Запущен findAll");
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user-list";
//        return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        log.info("Запущен createUserForm");
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        log.info("Запущен createUser");
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        log.info("Запущен deleteUser");
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String createUpdateUserForm(@PathVariable("id") int id, Model model){
        log.info("Запущен createUpdateUserForm");
        User user = userService.gtUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        log.info("Запущен updateUser");
        userService.updateUser(user);
        return "redirect:/users";
    }
}
