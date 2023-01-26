package com.seven.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    //use for businesses logic
    //example to sort the data came from db via repository

    @Autowired
    StudentRepository studentRepository;
    //1 create object and call the function
    //2 or create function static

    //function name could be different
    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public Student getStudent(int id){
        return studentRepository.getStudent(id);
    }

    public String deleteStudent(int id){
        return studentRepository.deleteStudent(id);
    }

    public String updateStudent(int id, int age){
        return studentRepository.updateStudent(id, age);
    }
}
