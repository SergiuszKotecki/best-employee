package com.employee.api.services;

import com.employee.api.models.Candidate;

public interface CandidateService {

    Candidate createNew(Candidate candidate);

    Candidate get(Candidate candidate);

    void deleteCandidate (Long id);
}
