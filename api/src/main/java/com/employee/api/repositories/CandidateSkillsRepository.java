package com.employee.api.repositories;

import com.employee.api.models.CandidateSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateSkillsRepository extends JpaRepository<CandidateSkills, Long> {
}
