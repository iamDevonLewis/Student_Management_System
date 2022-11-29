package com.blog.student.service;

import com.blog.student.entity.user.Student;

import java.util.List;

public interface StudentService {

     Student addStudent(Student student);
     List<Student> getStudents();

     Student getStudentById(Long id);
     Student updateStudent(Student student);

     void deleteStudent(Long id);


}
