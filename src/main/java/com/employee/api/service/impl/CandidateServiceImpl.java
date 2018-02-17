package com.employee.api.service.impl;

import com.employee.api.model.Candidate;
import com.employee.api.model.Role;
import com.employee.api.model.enums.RoleEnum;
import com.employee.api.repository.CandidateRepository;
import com.employee.api.service.CandidateService;
import com.employee.api.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


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

    @Override
    public String registerNewUser(Candidate candidate) {

        candidate.setPassword(passwordEncoder.encode(candidate.getPassword()));

        final Role USER_ROLE = roleService.findByAuthority(RoleEnum.CANDIDATE);
        candidate.setAuthorities(Collections.singletonList(USER_ROLE));

        return this.save(candidate);
    }

    @Override
    public String save(Candidate candidate) {
        try {
            candidate.setPassword(passwordEncoder.encode(candidate.getPassword()));
            candidateRepository.save(candidate);
            return candidate.getUuid();
        } catch (Exception e) {
            log.error(e.toString(), e);
            return null;
        }
    }

    @Override
    public Iterable<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate findByEmail(String email) {
        return candidateRepository.findByEmail(email);
    }

    @Override
    public Candidate findByUsername(String username) {
        return candidateRepository.findByUsername(username);
    }

    @Override
    public Candidate findById(String id) {
        return candidateRepository.findOne(id);
    }


}
