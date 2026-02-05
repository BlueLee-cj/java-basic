package com.example.lcj.base.unpackpack;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @PostMapping("/Student")
    public Student retrun(Student student) {
        System.out.println(student);
        System.out.println(student.getAge());
        return student;
    }
}
