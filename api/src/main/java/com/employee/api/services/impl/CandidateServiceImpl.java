package com.employee.api.services.impl;

import com.employee.api.models.Candidate;
import com.employee.api.repositories.CandidateRepository;
import com.employee.api.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public Candidate createNew(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate getById(Long uuid) {
        Candidate cand = candidateRepository.findOne(uuid);
        return cand;
    }

    @Override
    public void deleteCandidate(Long uuid) {
        candidateRepository.delete(uuid);
    }


}
