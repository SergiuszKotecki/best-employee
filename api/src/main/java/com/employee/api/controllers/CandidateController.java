package com.employee.api.controllers;


import com.employee.api.models.Candidate;
import com.employee.api.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping(value = "/candidate")
    public HttpEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
        candidateService.createNew(candidate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
