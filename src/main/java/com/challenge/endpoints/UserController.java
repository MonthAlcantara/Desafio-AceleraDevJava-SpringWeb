package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.impl.UserService;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable("id") Long userId)
    {
        return this.userService.findById(userId);
    }

    @GetMapping("/{name}")
    public List<User> findByAccelerationName(@PathVariable("name") String name) {
        return this.userService.findByAccelerationName(name);
    }

    @GetMapping
    public List<User> findByCompanyId(@RequestParam("id") Long companyId) {
        return this.userService.findByCompanyId(companyId);
    }

}
