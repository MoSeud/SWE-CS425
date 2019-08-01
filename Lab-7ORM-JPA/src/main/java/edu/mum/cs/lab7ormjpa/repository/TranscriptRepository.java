package edu.mum.cs.lab7ormjpa.repository;

import edu.mum.cs.lab7ormjpa.model.Transcript;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends CrudRepository<Transcript, Long> {
}
