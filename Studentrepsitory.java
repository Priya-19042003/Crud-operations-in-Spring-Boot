package com.example.sampleforjpademo.repository;

import com.example.sampleforjpademo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Studentrepsitory extends JpaRepository<Student,Integer> {
    List<Student> findByTechnology(String Technology);

    @Query(nativeQuery = true ,value="Select * from student where gender=:gender and technology=:technology")
    List<Student> findstudentsbygenderandtechnology(@Param("gender")String gender, @Param("technology") String technology);

}
