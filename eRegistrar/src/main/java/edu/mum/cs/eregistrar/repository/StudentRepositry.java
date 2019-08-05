package edu.mum.cs.eregistrar.repository;

import edu.mum.cs.eregistrar.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepositry extends JpaRepository<Student,Long> {
     List<Student> findStudentByStudentId(Long id);
}
