package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.impl.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable("id") Long id) {
        Optional<Company> companyOptional = this.companyService.findById(id);
        if (companyOptional.isPresent()) {
            return ResponseEntity.ok(companyOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Company>> findByAccelerationIdOrUserId(@RequestParam(value = "accelerationId", required = false) Optional<Long> accelerationId,
                                                                      @RequestParam(value = "userId", required = false) Optional<Long> userId) {
        if (accelerationId.isPresent()) {
            return ResponseEntity.ok(this.companyService.findByAccelerationId(accelerationId.get()));

        } else if (userId.isPresent()) {
            return ResponseEntity.ok(this.companyService.findByAccelerationId(userId.get()));
        } else
            return ResponseEntity.ok(Collections.EMPTY_LIST);
    }
}
