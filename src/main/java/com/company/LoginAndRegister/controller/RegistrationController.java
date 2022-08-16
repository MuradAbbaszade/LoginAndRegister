/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.LoginAndRegister.controller;

import com.company.LoginAndRegister.dto.UserDTO;
import com.company.LoginAndRegister.exception.NotEmptyException;
import com.company.LoginAndRegister.exception.UserAlreadyExistException;
import com.company.LoginAndRegister.service.UserService;
import com.company.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roma-cervice
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDTO userDto,BindingResult result,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email, 
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "matchingPassword", required = false) String matchingPassword,
            HttpServletRequest request) throws NotEmptyException {
        System.out.println(userDto.getEmail());
        System.out.println(result.hasErrors());
        try {
            if (result.hasErrors()) {
                throw new NotEmptyException("Not be empty");
            }
        } catch (NotEmptyException neEx) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("message", neEx.getMessage());
            return mv;
        }
        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("message", uaeEx.getMessage());
            return mv;
        }
        return new ModelAndView("successRegister", "user", userDto);
    }
}
