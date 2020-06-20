package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.exception.ResourceNotFoundException;
import com.challenge.service.impl.AccelerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/acceleration")
public class AccelerationController {
    @Autowired
    private AccelerationService accelerationService;

    @GetMapping
    public ResponseEntity<List<Acceleration>> findAllAccelerationByCompanyId(@RequestParam(name = "companyId") Long id) {
        return ResponseEntity.ok(accelerationService.findByCompanyId(id));
    }

    @GetMapping("/{id}")
    public Acceleration findAccelerationById(@PathVariable("id") Long id) {
        return accelerationService.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
