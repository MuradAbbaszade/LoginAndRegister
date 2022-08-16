/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.LoginAndRegister.service;

import com.company.LoginAndRegister.dto.UserDTO;
import com.company.LoginAndRegister.exception.UserAlreadyExistException;
import com.company.daoImpl.UserDAOImpl;
import com.company.entity.User;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserDAOImpl userDAO;
    
    @Override
    public User registerNewUserAccount(UserDTO userDto) throws UserAlreadyExistException{
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
              + userDto.getEmail());
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        //user.setRoles(Arrays.asList("ROLE_USER"));
        return userDAO.insert(user);
    }

    private boolean emailExists(String email) {
        return userDAO.findByEmail(email) != null;
    }
}
