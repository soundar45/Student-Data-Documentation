package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;



@RestController
@RequestMapping("/api/Student")
public class StudentController {
    

    @Autowired
    private StudentService dem;
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return dem.getStudentbyId(id);
    }
    @GetMapping("/all")
    public List<Student> getalldata() {
        return dem.getStudentAlldata();
    }   
    @DeleteMapping("/{id}")
    public String deleteById (@PathVariable int id ){
              return   dem. DeleteStudendDataById(id);
     }
    @DeleteMapping("/all")
    public String deleteall(){
       return   dem.deleteall();
        
    }
    // -------------------------------
    @PostMapping
    public String addStudent(@RequestBody Student data) {
       return  dem.addStudent(data);
    
    }
    @PutMapping("Modify/{id}")
    public Student modifyStudentdata(@PathVariable int  id, @RequestBody Student newdata ) {
        return dem.updatestudentdata(id , newdata);
    }
    }

    
    

