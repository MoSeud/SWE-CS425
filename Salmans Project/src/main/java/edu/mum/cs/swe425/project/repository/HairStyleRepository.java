package edu.mum.cs.swe425.project.repository;


import edu.mum.cs.swe425.project.domain.HairStyle;
import edu.mum.cs.swe425.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HairStyleRepository extends JpaRepository<HairStyle, Integer> {
}
