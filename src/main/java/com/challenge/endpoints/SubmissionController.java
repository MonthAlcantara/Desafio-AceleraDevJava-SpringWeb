package com.challenge.endpoints;

import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;
    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping("/{challengeId}/{accelerationId}")
    public ResponseEntity<?> findByChallengeIdAndAccelerationId(@PathVariable("challengeId") Long challengeId,
                                                             @PathVariable("accelerationId") Long accelerationId) {
        return ResponseEntity.ok(submissionMapper.map(submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId)));
    }
}