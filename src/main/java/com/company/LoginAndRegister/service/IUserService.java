
package com.company.LoginAndRegister.service;

import com.company.LoginAndRegister.dto.UserDTO;
import com.company.LoginAndRegister.exception.UserAlreadyExistException;
import com.company.entity.User;

public interface IUserService {
    User registerNewUserAccount(UserDTO userDto) throws UserAlreadyExistException;
}
