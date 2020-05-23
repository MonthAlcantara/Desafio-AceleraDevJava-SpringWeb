package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.impl.UserService;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long userId) {
        Optional<User> userOptional = this.userService.findById(userId);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> findByAccelerationNameOrCompanyId(@RequestParam(value = "accelerationName", required = false) Optional<String> accelerationName,
                                                                        @RequestParam(value = "companyId", required = false) Optional<Long> companyId) {
        if (accelerationName.isPresent()) {
            return ResponseEntity.ok(this.userService.findByAccelerationName(accelerationName.get()));
        } else if (companyId.isPresent()) {
            return ResponseEntity.ok(this.userService.findByCompanyId(companyId.get()));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
}
