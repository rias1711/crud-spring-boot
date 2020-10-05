package com.example.demo.controller;

import com.example.demo.model.MyUser;
import com.example.demo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MyUserController {

    @Autowired
    private MyUserService myUserService;

    @RequestMapping("/")
    public String index(Model model) {
        List<MyUser> users = myUserService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping(value = "/add")
    public String addUser(Model model) {
        model.addAttribute("user", new MyUser());
        return "add";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id")Long id, Model model) {
        Optional<MyUser> userEdit = myUserService.findUserById(id);
        userEdit.ifPresent(myUser -> model.addAttribute("user", myUser));
        return "edit";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveUser(MyUser myUser) {
        myUserService.save(myUser);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id")Long id, Model model) {
        myUserService.delete(id);
        return "redirect:/";
    }
}
