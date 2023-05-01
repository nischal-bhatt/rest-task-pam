package com.example.demo.controller;

import com.example.demo.model.MarksConverter;
import com.example.demo.model.Student;
import com.example.demo.service.PamService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@RestController
@RequestMapping("/api/v1/studentcontroller")
public class StudentController {

    @Autowired
    private PamService pamService;

    @PostMapping
    public MarksConverter geMarks(@RequestBody Student student) throws JsonProcessingException {



        System.out.println(student.getStudentId());

        return pamService.getMarks(student);




    }
}
