package com.employee.api.controller;


import com.employee.api.model.Candidate;
import com.employee.api.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    CandidateService candidateService;
    
    @GetMapping(value = "/candidate/")
    public HttpEntity<List<Candidate>> getAllCandidates(){
        List<Candidate> candidates = candidateService.getAllCandidates();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @PostMapping(value = "/candidate")
    public HttpEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
        Candidate cand = candidateService.createNew(candidate);
        return new ResponseEntity<>(cand, HttpStatus.CREATED);
    }

    @GetMapping(value = "/candidate/{id}")
    public HttpEntity<Candidate> getCandidateById(@PathVariable("id") String id) {
        Candidate cand = candidateService.getById(id);
        return hasEntity(cand);
    }

    @DeleteMapping(value = "/candidate/{id}")
    public HttpEntity<Candidate> deleteCandidateById(@PathVariable("id") String id) {
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/candidate/{id}")
    public HttpEntity<Candidate> updateCandidateById(@PathVariable("id") String id, @RequestBody Candidate candidate) {
        //TODO: create Candidate DTO model and parse it to Candidate Model
        Candidate cand = candidateService.uppdateCandidateData(id, candidate);
        return new ResponseEntity<>(cand, HttpStatus.OK);
    }

    private boolean isNull(Candidate candidate) {
        return (candidate != null);
    }

    private ResponseEntity hasEntity(Candidate cand) {
        if (isNull(cand)) {
            return new ResponseEntity<>(cand, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
