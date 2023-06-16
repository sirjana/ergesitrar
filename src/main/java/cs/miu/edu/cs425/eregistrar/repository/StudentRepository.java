package cs.miu.edu.cs425.eregistrar.repository;

import cs.miu.edu.cs425.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String name,String lastname);

}
