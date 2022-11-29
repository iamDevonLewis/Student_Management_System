package com.blog.student.service;

import com.blog.student.Repository.StudentRepository;
import com.blog.student.entity.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return (Student) studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }


    @Override
    public Student updateStudent(Student student) {

        return studentRepository.save(student);
      //check to see if student exist
//      Student existingStudent = (Student) studentRepository.findById(id).orElseThrow();
//
//        //Update Student
//       existingStudent.setFirstName(student.getFirstName());
//        existingStudent.setLastName(student.getLastName());
//        existingStudent.setEmail(student.getEmail());
//        existingStudent.setAddress(student.getAddress());
//       existingStudent.setPhone(student.getPhone());
//        studentRepository.save(existingStudent);
//       return existingStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
