package com.employee.api.controllers;


import com.employee.api.models.Candidate;
import com.employee.api.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CandidateController {

    @Autowired
    CandidateRepository candidateRepository;

    @RequestMapping(value = "/candidate", method = RequestMethod.POST)
    public Candidate addCandidate (@RequestBody Candidate candidate){
        Candidate cand = new Candidate(
                candidate.getId(),
                candidate.getFirstName(),
                candidate.getLastName(),
                candidate.getEmail(),
                candidate.getDesiredPosition(),
                candidate.getSkillLevel(),
                candidate.getCity(),
                candidate.isRemote()
        );

        candidateRepository.save(cand);

        return candidateRepository.findOne(candidate.getId());
    }

}
