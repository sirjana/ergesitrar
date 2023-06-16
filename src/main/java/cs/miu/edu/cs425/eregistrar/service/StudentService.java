package cs.miu.edu.cs425.eregistrar.service;

import cs.miu.edu.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {

    public abstract Student addNewStudent(Student newStudent);
     public abstract List<Student> getAllStudents();
     Student getStudent(Long studentId);
     Student updateStudent(Student student);

    void deleteStudent(Long id);

    List<Student> searchstudent(String studentName);
}

