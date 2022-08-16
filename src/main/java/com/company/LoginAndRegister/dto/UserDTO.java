/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.LoginAndRegister.dto;
import com.company.LoginAndRegister.annotation.PasswordMatches;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 *
 * @author roma-cervice
 */
@PasswordMatches
public class UserDTO {
    @NotEmpty(message="Can't be empty")
    @Size(min=2,max=15,message="Name size must be between 2 and 15")
    private String name;
    @NotEmpty(message="Can't be empty")
    @Size(min=11,max=35,message="Email size must be between 11 and 35")
    private String email;
    @NotEmpty(message="Can't be empty")
    @Size(min=3,max=25,message="Password size must be between 3 and 25")
    private String password;
    private String matchingPassword;

    public UserDTO() {
    }

    public UserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
    
}
