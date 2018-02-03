package com.employee.api.service;

import com.employee.api.model.Candidate;

import java.util.List;

public interface CandidateService {

    Candidate createNew(Candidate candidate);

    Candidate getById(String uuid);

    Candidate uppdateCandidateData(String uuid, Candidate candidate);

    void deleteCandidate (String uuid);

    List<Candidate> getAllCandidates();

}
