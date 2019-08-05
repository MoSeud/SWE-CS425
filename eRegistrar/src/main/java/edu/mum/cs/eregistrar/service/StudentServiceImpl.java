package edu.mum.cs.eregistrar.service;

import edu.mum.cs.eregistrar.domain.Student;
import edu.mum.cs.eregistrar.repository.StudentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements  StudentService {
    @Autowired
    private StudentRepositry studentRepositry;

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepositry.findAll();
    }

    @Override
    public Page<Student> getAllStudentByPagesByPage(int page) {
        return studentRepositry.findAll(PageRequest.of(page,3, Sort.by("studentId")));
    }

    @Override
    public List<Student> findStudentsById(Long id) {
        return studentRepositry.findStudentByStudentId(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepositry.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
studentRepositry.deleteById(studentId);
    }
}
