package com.employee.api.service.impl;

import com.employee.api.model.Candidate;
import com.employee.api.repository.CandidateRepository;
import com.employee.api.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public Candidate createNew(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate getById(String uuid) {
        return candidateRepository.findOne(uuid);
    }

    @Override
    public Candidate uppdateCandidateData(String uuid, Candidate candidate) {
        Candidate cand = candidateRepository.findOne(uuid);
        cand.setFirstName(candidate.getFirstName());
        candidateRepository.save(cand);
        return cand;
    }

    @Override
    public void deleteCandidate(String uuid) {
        candidateRepository.delete(uuid);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }



}
