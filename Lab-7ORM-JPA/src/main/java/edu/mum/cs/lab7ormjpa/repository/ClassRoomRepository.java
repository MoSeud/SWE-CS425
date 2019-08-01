package edu.mum.cs.lab7ormjpa.repository;

import edu.mum.cs.lab7ormjpa.model.ClassRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends CrudRepository<ClassRoom,Long> {
}
