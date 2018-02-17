package com.employee.api.service.impl;

import com.employee.api.model.Candidate;
import com.employee.api.service.CandidateService;
import com.employee.api.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService, CustomUserDetailsService {

    @Autowired
    private CandidateService candidateService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Candidate candidate = candidateService.findByUsername(username);
        if (candidate == null) {
            throw new UsernameNotFoundException("No such user in database");
        }
        return candidate;
    }

}

