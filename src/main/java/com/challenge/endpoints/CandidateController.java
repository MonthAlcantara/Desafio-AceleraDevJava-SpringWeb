package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public ResponseEntity<CandidateDTO> findCandidateByUserIdAndCompanyIdAndAccelerationId(@PathVariable("UserId") Long userId,
                                                                                           @PathVariable("companyId") Long companyId,
                                                                                           @PathVariable("accelerationId") Long accelerationId) {
        Optional<Candidate> candidateOptional = candidateService.findById(userId, companyId, accelerationId);
        return ResponseEntity.ok(candidateMapper.map(candidateOptional.orElse(new Candidate())));
    }


    @GetMapping
    public ResponseEntity<List<CandidateDTO>> findByCompanyIdOrAccelerationId(@RequestParam(value = "companyId", required = false) Optional<Long> companyId,
                                                                              @RequestParam(value = "accelerationId", required = false) Optional<Long> accelerationId) {
        if (companyId.isPresent()) {
            return ResponseEntity.ok(candidateMapper.map(candidateService.findByCompanyId(companyId.get())));
        } else if (accelerationId.isPresent()) {
            return ResponseEntity.ok(candidateMapper.map(candidateService.findByAccelerationId(accelerationId.get())));
        } else
            return ResponseEntity.ok(Collections.emptyList());
    }
}

