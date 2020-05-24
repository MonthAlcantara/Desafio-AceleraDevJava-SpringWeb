package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> findAllCompanyByAccelerationIdOrUserId(
            @RequestParam(name = "accelerationId", required = false) Optional<Long> accelerationId,
            @RequestParam(name = "userId", required = false) Optional<Long> userId) {
        if (accelerationId.isPresent()) {
            return ResponseEntity.ok(companyService.findByAccelerationId(accelerationId.get()));
        } else if (userId.isPresent()) {
            return ResponseEntity.ok(companyService.findByUserId(userId.get()));
        } else {
            return ResponseEntity.ok(Collections.EMPTY_LIST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable("id") Long id) {
        Optional<Company> companyOptional = companyService.findById(id);
        if (companyOptional.isPresent()) {
            return ResponseEntity.ok(companyOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

}
