package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.impl.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    @GetMapping("/{id}")
    public Optional<Company> findById(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }

    @GetMapping
    public List<Company> findByAccelerationId(@RequestParam("accelerationId") Long accelerationId) {
        return this.companyService.findByAccelerationId(accelerationId);
    }

    @GetMapping
    public List<Company> findByUserId(@RequestParam("userId") Long userId) {
        return this.companyService.findByUserId(userId);
    }
}
