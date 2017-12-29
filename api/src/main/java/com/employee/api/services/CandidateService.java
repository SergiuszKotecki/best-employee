package com.employee.api.services;

import com.employee.api.models.Candidate;

import java.util.List;

public interface CandidateService {

    Candidate createNew(Candidate candidate);

    Candidate getById(Long uuid);

    Candidate uppdateCandidateData(Long uuid, Candidate candidate);

    void deleteCandidate (Long uuid);

    List<Candidate> getAllCandidates(int pageNumber);

}
