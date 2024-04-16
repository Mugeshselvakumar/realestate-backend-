package com.mugesh.realestate.controller;

import com.mugesh.realestate.model.User;
import com.mugesh.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService loginService;

    @PostMapping("/login")
    public User newLogin(@RequestBody User newLogin) {
        return loginService.createLogin(newLogin);
    }

    @GetMapping("/logins")
    public List<User> getAllLogins() {
        return loginService.getAllLogins();
    }

    @GetMapping("/logins/paginated")
    public Page<User> getAllLoginsPaginated(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "5") int size) {
        return loginService.getAllLoginsPaginated(page, size);
    }

    @GetMapping("/logins/sorted")
    public List<User> getAllLoginsSorted(@RequestParam(defaultValue = "username") String sortBy,
                                         @RequestParam(defaultValue = "asc") String direction) {
        return loginService.getAllLoginsSorted(sortBy, direction);
    }

    @GetMapping("/by-email/{email}")
    public List<User> getLoginsByEmail(@PathVariable String email) {
        return loginService.getLoginsByEmail(email);
    }



    @PutMapping("/login/{id}")
    public User updateLogin(@RequestBody User newLogin, @PathVariable Long id) {
        return loginService.updateLogin(newLogin, id);
    }

    @DeleteMapping("/login/{id}")
    public String deleteLogin(@PathVariable Long id) {
        return loginService.deleteLogin(id);
    }
}
