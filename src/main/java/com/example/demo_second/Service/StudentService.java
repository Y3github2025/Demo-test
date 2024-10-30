package com.example.demo_second.Service;

import com.example.demo_second.Model.Student;
import com.example.demo_second.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student updateStudent(Long id, Student studentDetail) {
        Student student = studentRepo.findById(id).orElseThrow();
        student.setName(studentDetail.getName());
        student.setAge(studentDetail.getAge());
        student.setGender(studentDetail.getGender());
        student.setEmail(studentDetail.getEmail());
        return studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
