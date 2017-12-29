package com.employee.api.services.impl;

import com.employee.api.models.Candidate;
import com.employee.api.repositories.CandidateRepository;
import com.employee.api.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

    private final static int PAGESIZE = 3;

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
    public Candidate uppdateCandidateData(Long uuid, Candidate candidate) {
        Candidate cand = candidateRepository.findOne(uuid);
        cand.setFirstName(candidate.getFirstName());
        candidateRepository.save(cand);
        return cand;
    }

    @Override
    public void deleteCandidate(Long uuid) {
        candidateRepository.delete(uuid);
    }

    @Override
    public List<Candidate> getAllCandidates(int pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "createdAt");
        return candidateRepository.findAll(request).getContent();
    }



}
