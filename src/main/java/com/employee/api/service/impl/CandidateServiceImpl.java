package com.employee.api.service.impl;

import com.employee.api.model.Candidate;
import com.employee.api.repository.CandidateRepository;
import com.employee.api.service.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public Candidate createNew(Candidate candidate) {
        try {
            return candidateRepository.save(candidate);
        } catch (PersistenceException e) {
            log.info("Error while saving" + candidate.toString() + " " + e.toString());
            return candidate;
        }
    }

    @Override
    public Candidate getById(String uuid) {
        return candidateRepository.findOne(uuid);
    }

    @Override
    public Candidate uppdateCandidateData(String uuid, Candidate candidate) {
        Candidate cand = candidateRepository.findOne(uuid);
        cand.setFirstName(candidate.getFirstName());
        try {
            return candidateRepository.save(cand);
        } catch (PersistenceException e) {
            log.info("Error while saving" + cand.toString() + " " + e.toString());
            return candidate;
        }
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
