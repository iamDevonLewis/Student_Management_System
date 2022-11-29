package com.blog.student.controller;

import com.blog.student.entity.user.Student;
import com.blog.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class studentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getAllStudent(Model model){
        model.addAttribute("students", studentService.getStudents());
        return "Students";
    }

    @GetMapping("/students/add")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student_form";
    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/update/{id}")
    public String getStudentForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";


    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student, Model model){
        //check to see if student exist
        Student existingStudent = (Student) studentService.getStudentById(id);

       //Update Student
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setPhone(student.getPhone());
        studentService.updateStudent(existingStudent);


        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
