package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.impl.CandidateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class CandidateController {
    private CandidateService candidateService;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public Optional<Candidate> findById(@PathVariable("UserId")Long userId, @PathVariable("companyId")Long companyId, @PathVariable("accelerationId")Long accelerationId) {
        return candidateService.findById(userId, companyId, accelerationId);
    }

    @GetMapping("/{id}")
    public List<Candidate> findByCompanyId(@PathVariable("id") Long companyId) {
        return candidateService.findByCompanyId(companyId);
    }

    @GetMapping
    public List<Candidate> findByAccelerationId(@RequestParam("id") Long accelerationId) {
        return candidateService.findByAccelerationId(accelerationId);
    }
}

