package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public Optional<Candidate> findById(@PathVariable("UserId")Long userId, @PathVariable("companyId")Long companyId, @PathVariable("accelerationId")Long accelerationId) {
        return this.candidateService.findById(userId, companyId, accelerationId);
    }

    @GetMapping("/{id}")
    public List<Candidate> findByCompanyId(@PathVariable("id") Long companyId) {
        return this.candidateService.findByCompanyId(companyId);
    }

    @GetMapping
    public List<Candidate> findByAccelerationId(@RequestParam("id") Long accelerationId) {
        return this.candidateService.findByAccelerationId(accelerationId);
    }
}

