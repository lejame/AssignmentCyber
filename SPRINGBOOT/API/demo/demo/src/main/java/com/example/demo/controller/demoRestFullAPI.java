package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class demoRestFullAPI {

    @GetMapping("/lo")
    public ResponseEntity<?> demo(){
        Student student = new Student("Lê Hữu Lợi",21,"0123123123");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
