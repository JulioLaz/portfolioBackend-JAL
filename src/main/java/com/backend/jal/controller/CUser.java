package com.backend.jal.controller;

import com.backend.jal.entity.User;
import com.backend.jal.service.SUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-julio-lazarte.web.app"})
public class CUser {
    @Autowired
    SUser sUser;
    
    @GetMapping("/lista")
    public ResponseEntity<List<User>> list(){
        List<User> list = sUser.findAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
