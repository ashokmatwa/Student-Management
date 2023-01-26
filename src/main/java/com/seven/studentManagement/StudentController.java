package com.seven.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addStudent(@RequestBody Student student){
        String  response = studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED );
    }

    //get=READ
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("q") int admnNo){
        Student student = studentService.getStudent(admnNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    //update=PUT
    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("u") int admNo, @RequestParam("ag") int age){
        String response = studentService.updateStudent(admNo, age);
        if(response==null) {
            return new ResponseEntity<>("INVALID request", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //delete=DELETE
    @DeleteMapping("/delete_student")
    public ResponseEntity deleteStudent(@RequestParam("d") int admnNo){
        String response = studentService.deleteStudent(admnNo);
        if(response.equals("INVALID INPUT"))
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

//    //create=POST
//    @PostMapping("/add_student")
//    public String addStudent(@RequestBody Student student){
//        return studentService.addStudent(student);
//    }
//
//    //get=READ
//    @GetMapping("/get_student")
//    public Student getStudent(@RequestParam("q") int admnNo){
//        return studentService.getStudent(admnNo);
//    }
//
//    //update=PUT
//    @PutMapping("/update_student")
//    public String updateStudent(@RequestParam("u") int admNo, @RequestParam("ag") int age){
//        return studentService.updateStudent(admNo, age);
//    }
//
//    //delete=DELETE
//    @DeleteMapping("/delete_student")
//    public String deleteStudent(@RequestParam("d") int admnNo){
//        return studentService.deleteStudent(admnNo);
//    }

}
