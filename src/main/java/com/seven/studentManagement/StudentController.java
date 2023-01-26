package com.seven.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//specifies that it has APIs
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    //function name could be different

    //create=POST
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //get=READ
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("q") int admnNo){
        return studentService.getStudent(admnNo);
    }

    //update=PUT
    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("u") int admNo, @RequestParam("ag") int age){
        return studentService.updateStudent(admNo, age);
    }

    //delete=DELETE
    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("d") int admnNo){
        return studentService.deleteStudent(admnNo);
    }

}
