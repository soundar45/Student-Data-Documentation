package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Exception.NodataFoundException;
import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepo;

@Service
public class StudentServiceimpl implements  StudentService {
    @Autowired
    private StudentRepo repo;

    @Override
    public String addStudent(Student data) {
        try {

            if(data.getName()== null || data.getName().isBlank())
                return "Invalid student data. Please check your Name";
            if(data.getAddress()==null || data.getAddress().isBlank())
                return "Invalid student data. Please check your address";
            if(data.getEmail()==null || !data.getEmail().contains("@")) 
                return "Invalid student data. Please check your Email -@ ";
            
                 repo.save(data);
                return "Student Data saved Successfully";

        } catch (Exception e) {
            return "Error occurred while saving student data";
        }      
}
    @Override
   public List <Student> getStudentAlldata(){
       List <Student> Alldata = repo.findAll();
        if(Alldata.isEmpty()){
            throw new NodataFoundException("DataBase was Empty!");
        }
        return Alldata;
       }
    @Override
    public Student getStudentbyId(int id ){
      return   repo.findById(id)
                    .orElseThrow(() -> new NodataFoundException("Student Id "+ id +"Not Found!"));
}
    @Override
    public String DeleteStudendDataById(int id ){
         repo.findById(id).orElseThrow(()-> new NodataFoundException("Student Id"+ id +" Not Found!"));   
         repo.deleteById(id);
         return "Student ID " + id + " deleted successfully!";
}
    @Override
    public String deleteall(){
        repo.deleteAll();
        return"All Data Deleted Successfully";
        
}   
    @Override
    public Student updatestudentdata(@PathVariable int id , @RequestBody Student newdata){
        Student olddata = repo.findById(id)
                                    .orElseThrow(() -> new NodataFoundException("Student ID"+ id + "Not Found"));
                olddata.setName(newdata.getName());
                olddata.setEmail(newdata.getEmail());
                olddata.setAddress(newdata.getAddress());
        return repo.save(olddata);
    }
   



}
   
  
        // if(data == null  
        //    || data.getName()==null || data.getName().isBlank()
        //    || data.getAddress()==null||data.getAddress().isBlank()
        //    || data.getEmail()==null||data.getEmail().isBlank()){
        //     return ("Enter Your Correct Details");
        // }
        //  Student saved=repo.save(data);
        // return "Student Details Saved " + saved.getId();
          

