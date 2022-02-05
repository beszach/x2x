package com.example.pptaskspringboot.rest.controller;

import com.example.pptaskspringboot.rest.model.Role;
import com.example.pptaskspringboot.rest.model.User;
import com.example.pptaskspringboot.rest.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
//    private final AppService appService;
//
//    @Autowired
//    public AdminController(AppService appService) {
//        this.appService = appService;
//    }


    @GetMapping()
    public String index() {
//        model.addAttribute("users", appService.getAllUsers());
//        model.addAttribute("user", user);
//        model.addAttribute("newUser", new User());
        return "/admin";
    }
}
//
////    @GetMapping("/{id}")
////    public String showUser(@PathVariable("id") Long id, Model model) {
////        model.addAttribute("user", appService.show(id));
////        return "/user";
////    }
//
////    @GetMapping("/new")
////    public String newUser(Model model) {
////        model.addAttribute("user", new User());
////        return "/new";
////    }
//
//    @PostMapping()
//    public String createUser(@ModelAttribute("user") User user,
//                             @RequestParam(name = "role") String [] roles) {
//        Set <Role> roleSet = new HashSet<>();
//        if (roles != null){
//            for (String role: roles){
//                roleSet.add(appService.getRoleByName(role));
//            }
//        }
//        user.setRoles(roleSet);
//        appService.add(user);
//        return "redirect:/admin";
//    }
//
////    @GetMapping("/{id}/edit")
////    public String edit(@PathVariable("id") Long id, Model model) {
////        model.addAttribute("user", appService.show(id));
////        return "/edit";
////    }
//
//    @PatchMapping("/{id}")
//    public String updateUser(@ModelAttribute("user") User user,
//                             @RequestParam(name = "role") String [] roles) {
//        Set <Role> roleSet = new HashSet<>();
//
//        if (roles != null){
//            for (String role: roles){
//                roleSet.add(appService.getRoleByName(role));
//            }
//        }
//        user.setRoles(roleSet);
//        appService.update(user);
//        return "redirect:/admin";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        appService.delete(id);
//        return "redirect:/admin";
//    }
//}
