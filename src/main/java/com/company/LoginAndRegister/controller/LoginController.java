/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.LoginAndRegister.controller;

import com.company.LoginAndRegister.dto.UserDTO;
import com.company.LoginAndRegister.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author roma-cervice
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    MyUserDetailsService userService;

    @GetMapping
    public String showLoginForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "login";
    }
}
