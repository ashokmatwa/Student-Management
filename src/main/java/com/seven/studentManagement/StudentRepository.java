package com.seven.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    //logic to connect to the sql
    //CRUD operation

    Map<Integer, Student> db = new HashMap<>(); // as we have not db so use for temporary purpose

    public String addStudent(Student student){
        int id = student.getAdmNo();
        db.put(id, student);
        return "Student added successfully";
    }
    public Student getStudent(int id){
        return db.get(id);
    }

    public String deleteStudent(int id){
        if(db.containsKey(id)){
            db.remove(id);
            return "Deleted successfully";
        }
        return "INVALID INPUT";
    }

    public String updateStudent(int id, int age){

        if(!db.containsKey(id))
            return "Student Not Found !!!";

//        Student student = db.get(admNo); // get the student corresponds to admNo
//        student.setAge(age);
//        db.put(admNo, student);

        db.get(id).setAge(age);  // ideal shorthand code
        return "Updated successfully";
    }

}
