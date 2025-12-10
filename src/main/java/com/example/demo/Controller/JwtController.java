package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Secuirty.JwtService;


@RestController
@RequestMapping("/jwt")

public class JwtController {

    @Autowired
    private JwtService dem;
    
    @PostMapping("/create")
    public String getUsernamePassword(@RequestParam String username, @RequestParam String password){
        if (username.equals("soundar") && password.equals("sksindia123@#")){
            String temp = dem.generateToken(username);
            return temp;
        }
        return "invalid";

    }

    
}
    
