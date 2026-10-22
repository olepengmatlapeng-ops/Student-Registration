package com.StudentManagement.Student.Registration.Controller;

import com.StudentManagement.Student.Registration.Model.Student;
import com.StudentManagement.Student.Registration.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/")
    public String viewPage(Model model) {
        model.addAttribute("students", repo.findAll());
        return "homepage";
    }

    @GetMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "new_student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        repo.save(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable int id, Model model) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id: " + id));
        model.addAttribute("student", student);
        return "edit_student";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute("student") Student student) {
        repo.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}