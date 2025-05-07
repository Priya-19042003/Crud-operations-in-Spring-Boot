package com.example.sampleforjpademo.controller;

import com.example.sampleforjpademo.model.Student;
import com.example.sampleforjpademo.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class Studentcontroller {
    @Autowired
  private Studentservice studentservice;

    @GetMapping("/students")
    public List<Student> getallstudents(){

        return studentservice.getallstudents();
    }

    @PostMapping("/students")
    public String addstudents(@RequestBody Student student)
    {
        studentservice.addstudents(student);
        return "added successfully";
    }

    @GetMapping("/students/{rollno}")
    public Student getstudentsbyid(@PathVariable("rollno") int rollno)
    {
        return studentservice.getstudentsbyid(rollno);
    }

    @GetMapping("/students/technology/{technology}")
    public List<Student> getstudentsbytechnology(@PathVariable("technology") String technology)
    {
        return studentservice.getstudentsbytechnology(technology);

    }

    @PostMapping("/students/filter")
    public List<Student> findstudentsbygenderandtechnology(@Param("gender") String gender, @Param("technology") String technology)
    {
        return studentservice.findstudentsbygenderandtechnology(gender,technology);
    }

    @PutMapping("/students")
    public String updatestudents(@RequestBody Student student){
        studentservice.updatestudents(student);
        return "updated successfully";
    }

    @DeleteMapping("students/{rollno}")
    public String deletestudentsbyid(@PathVariable ("rollno") int rollno)
    {
        studentservice.deletestudentsbyid(rollno);
        return "deleted successfully";
    }

    @DeleteMapping("/students/clear")
    public String deleteall(Student student)
    {
        studentservice.deleteall(student);
        return "recors cleared";
    }
}
