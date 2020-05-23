package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {
    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<Acceleration> accelerationOptional = this.accelerationService.findById(id);
           if(accelerationOptional.isPresent()) {
               return ResponseEntity.ok(accelerationOptional.get());
           }else
               return  ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<?> findByCompanyId(@RequestParam(value = "id") Long companyId) {
        return ResponseEntity.ok(this.accelerationService.findByCompanyId(companyId));
    }
}
