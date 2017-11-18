package com.wa.controllers;

import com.wa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/user/list";
    }

//    @RequestMapping({"/product/list", "/product"})
//    public String listProducts(Model model){
//        model.addAttribute("products", userService.listAll());
//        return "product/list";
//    }
//
//    @RequestMapping("/product/show/{id}")
//    public String getProduct(@PathVariable String id, Model model){
//        model.addAttribute("product", userService.getById(Long.valueOf(id)));
//        return "product/show";
//    }
//
//    @RequestMapping("/product/delete/{id}")
//    public String delete(@PathVariable String id){
//        userService.delete(Long.valueOf(id));
//        return "redirect:/product/list";
//    }
}
