package com.StudentManagement.Student.Registration.Repository;

import com.StudentManagement.Student.Registration.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
