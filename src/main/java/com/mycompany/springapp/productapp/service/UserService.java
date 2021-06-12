package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.UserModel;
import com.mycompany.springapp.productapp.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserCrudRepository ucr;
    
    public Long login(UserModel userModel)
    {
        Optional<UserModel> optionalUserModel = ucr.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        if(optionalUserModel.isPresent())
        {
            return optionalUserModel.get().getId();
        }
        return 0L;
    }
    public UserModel register(UserModel userModel)
    {
        userModel = ucr.save(userModel);
        return userModel;
    }
}
