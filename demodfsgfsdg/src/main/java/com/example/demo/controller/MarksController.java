package com.example.demo.controller;

import com.anotherproject.marksproject.Marks;
import com.anotherproject.marksproject.MarksInformation;
import com.anotherproject.marksproject.StudentInformation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/markscontroller")
public class MarksController {

    @PostMapping
    public Marks getMarks(@RequestBody StudentInformation student) {

        System.out.println("web service hit!");
        System.out.println(student.getStudentId());
        System.out.println(student.getStudentName());

        MarksInformation marksInformation = new MarksInformation();
        Marks marksInformationInner = new Marks();

        if(student.getStudentId() == 3)
        {
            marksInformationInner.setMarks(20);
            marksInformationInner.setAnotherField("dev");
        }else if (student.getStudentId() == 4)
        {
            marksInformationInner.setMarks(30);
            marksInformationInner.setAnotherField("digant");
        }else if (student.getStudentId() == 5)
        {
            marksInformationInner.setMarks(80);
            marksInformationInner.setAnotherField("hemlata");
        }else {
            marksInformationInner.setMarks(245);
            marksInformationInner.setAnotherField("hi nish");
        }

        marksInformation.setMarksInformationInner(marksInformationInner);








        return marksInformationInner;

    }

}
