package com.BIKE4USpringBoot.bike4u.apirest.User.DTO;

import com.BIKE4USpringBoot.bike4u.apirest.User.User;

public class UserOutputDTO {
    public String userName;
    public String email;
    public String password;

    public UserOutputDTO(User user) {
        if(user.getUserName()!=null)this.userName=user.getUserName();
        if(user.getEmail()!=null)this.email=user.getEmail();
        if(user.getPassword()!=null)this.password= user.getPassword();
    }
}
