package com.employee.api.repository;

import com.employee.api.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {

    Candidate findByEmail(String email);

    Candidate findByUsername(String userName);
}