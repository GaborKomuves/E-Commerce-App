package com.diy.e_commerce_app.services;

import com.diy.e_commerce_app.models.User;
import com.diy.e_commerce_app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Crează un utilizator nou
    public User createUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }


        // Setează datele suplimentare dacă sunt necesare
        if (user.getFirstName () == null || user.getLastName () == null) {
            throw new RuntimeException("First name or last name is null");
        }
        return userRepository.save(user);
    }

    // Obține toți utilizatorii
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obține un utilizator după ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Actualizează un utilizator
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setFirstName ( updatedUser.getFirstName() );
        existingUser.setLastName ( updatedUser.getLastName() );
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setRole(updatedUser.getRole());

        if (updatedUser.getFirstName() != null) {
            existingUser.setFirstName(updatedUser.getFirstName());
        }
        if (updatedUser.getLastName() != null) {
            existingUser.setLastName(updatedUser.getLastName());
        }
        if (updatedUser.getUsername() != null) {
            existingUser.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getEmail() != null) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPassword() != null) {
            existingUser.setPassword(updatedUser.getPassword());
        }
        if (updatedUser.getRole() != null) {
            existingUser.setRole(updatedUser.getRole());
        }


        return userRepository.save(existingUser);
    }

    // Șterge un utilizator
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
