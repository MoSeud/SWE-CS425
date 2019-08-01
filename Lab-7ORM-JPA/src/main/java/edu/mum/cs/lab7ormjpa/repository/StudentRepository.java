package edu.mum.cs.lab7ormjpa.repository;

import edu.mum.cs.lab7ormjpa.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
