package com.example.sampleforjpademo.service;

import com.example.sampleforjpademo.model.Student;
import com.example.sampleforjpademo.repository.Studentrepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studentservice {
    @Autowired
    private Studentrepsitory studentrepsitory;
    public List<Student> getallstudents() {
        return studentrepsitory.findAll();
    }

    public void addstudents(Student student) {
       studentrepsitory.save(student);
    }

    public Student getstudentsbyid(int rollno) {
        return studentrepsitory.findById(rollno).orElse(new Student());
    }

    public void updatestudents(Student student) {
         studentrepsitory.save(student);
    }

    public void deletestudentsbyid(int rollno) {
        studentrepsitory.deleteById(rollno);
    }

    public void deleteall(Student student) {
        studentrepsitory.deleteAll();
    }

    public List<Student> getstudentsbytechnology(String technology) {
        return studentrepsitory.findByTechnology(technology);
    }

    public List<Student> findstudentsbygenderandtechnology(String gender, String technology) {
      return studentrepsitory.findstudentsbygenderandtechnology(gender,technology);

    }
}
