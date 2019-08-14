package edu.mum.cs.swe425.project.repository;

import edu.mum.cs.swe425.project.domain.BusinessDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessDayRepository extends JpaRepository<BusinessDay, Integer> {
}
