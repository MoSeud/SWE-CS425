package edu.mum.cs.eregistrar.service;

import edu.mum.cs.eregistrar.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    public abstract Iterable<Student> getAllStudents();
    public abstract Page<Student> getAllStudentByPagesByPage(int page);
    public abstract List<Student> findStudentsById(Long id);
    public abstract Student saveStudent(Student student);
    public abstract void deleteStudentById(Long studentId);
}
