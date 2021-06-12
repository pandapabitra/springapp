package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.UserModel;
import com.mycompany.springapp.productapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserService us;

    @PostMapping(path = "/users")
    public ResponseEntity<String> login(@RequestBody UserModel userModel)
    {
        Long response = us.login(userModel);
        ResponseEntity<String> res = null;
        if(response == 0L)
        {
            res = new ResponseEntity<>("Incorrect Email or Password", HttpStatus.UNAUTHORIZED);
        }
        else
        {
            res = new ResponseEntity<>("OK", HttpStatus.OK);
        }
        return res;
    }

    @PostMapping(path = "/users/register")
    public ResponseEntity<UserModel> register(@RequestBody UserModel userModel)
    {
        userModel = us.register(userModel);
        ResponseEntity<UserModel> res = new ResponseEntity<UserModel>(userModel, HttpStatus.CREATED);
        return res;
    }
}
