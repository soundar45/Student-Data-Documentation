package com.example.demo.Service;
import java.util.List;

import com.example.demo.Model.Student;

public interface StudentService {
    //get n getid
    Student getStudentbyId(int id);
    List<Student>getStudentAlldata();


    //deleteid n deleteall
    String  DeleteStudendDataById (int id);
    String deleteall();


    //post
     String addStudent(Student data);

     //updatedata
     Student updatestudentdata(int id, Student newdata);
     


    

   
}
