package com.challenge.endpoints;

import com.challenge.entity.Submission;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @RequestMapping("/{challengeId}/{accelerationId}")
    public List<Submission> findByChallengeIdAndAccelerationId(@PathVariable("challengeId") Long challengeId, @PathVariable("accelerationId") Long accelerationId) {
        return this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }
}