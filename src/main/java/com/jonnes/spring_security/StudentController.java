package com.jonnes.spring_security;


import com.jonnes.spring_security.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students= new ArrayList<>(List.of( new Student(1, "jonnes","java"),
                                                     new Student(2,"Kabilan","Python"),
                                                      new Student(3,"Kalith","JavaScript")));

    @GetMapping("students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("students")
    public void addStudents(@RequestBody Student student){
        students.add(student);
    }
}
