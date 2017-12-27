package com.employee.api.services.impl;

import com.employee.api.models.Candidate;
import com.employee.api.repositories.CandidateRepository;
import com.employee.api.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public Candidate createNew(Candidate candidate) {
        return null;
    }

    @Override
    public Candidate get(Candidate candidate) {
        return null;
    }

    @Override
    public void deleteCandidate(Long id) {

    }
}
