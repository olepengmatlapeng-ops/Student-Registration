package com.StudentManagement.Student.Registration.Service;

import com.StudentManagement.Student.Registration.Model.Student;
import com.StudentManagement.Student.Registration.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

}
