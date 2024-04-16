package com.mugesh.realestate.service;

import com.mugesh.realestate.model.User;
import com.mugesh.realestate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository loginRepository;

    public User createLogin(User newLogin) {
        return loginRepository.save(newLogin);
    }

    public List<User> getAllLogins() {
        return loginRepository.findAll();
    }

    public Page<User> getAllLoginsPaginated(int page, int size) {
        return loginRepository.findAll(PageRequest.of(page, size));
    }

    public List<User> getAllLoginsSorted(String sortBy, String direction) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        return loginRepository.findAll(Sort.by(sortDirection, sortBy));
    }

    public List<User> getLoginsByEmail(String email) {
        return loginRepository.findByEmail(email);
    }

    public Optional<User> getLoginById(Long id) {
        return loginRepository.findById(id);
    }

    public User updateLogin(User newLogin, Long id) {
        return loginRepository.findById(id)
                .map(login -> {
                    login.setUsername(newLogin.getUsername());
                    login.setName(newLogin.getName());
                    login.setEmail(newLogin.getEmail());
                    return loginRepository.save(login);
                }).orElse(null);
    }

    public String deleteLogin(Long id) {
        if (loginRepository.existsById(id)) {
            loginRepository.deleteById(id);
            return "Login with id " + id + " has been deleted successfully.";
        } else {
            return "Login with id " + id + " does not exist.";
        }
    }
}
