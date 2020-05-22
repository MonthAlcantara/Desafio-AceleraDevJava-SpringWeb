package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    private ChallengeRepository repository;

    @GetMapping("/accelerationId/userId")
    public List<Challenge> findByAccelerationIdAndUserId(@PathParam("accelerationId") Long accelerationId,@PathParam("userId") Long userId) {
        return repository.findByAccelerationIdAndUserId(accelerationId, userId);
    }
}
