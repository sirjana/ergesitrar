package cs.miu.edu.cs425.eregistrar.service.Impl;

import cs.miu.edu.cs425.eregistrar.model.Student;
import cs.miu.edu.cs425.eregistrar.repository.StudentRepository;
import cs.miu.edu.cs425.eregistrar.service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

 private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addNewStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public  Student getStudent(Long studentId){
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> searchstudent(String studentName) {
     return studentRepository.findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(studentName,studentName);
    }

}
