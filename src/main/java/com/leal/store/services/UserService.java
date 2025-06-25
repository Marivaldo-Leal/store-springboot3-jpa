package com.leal.store.services;

import com.leal.store.entities.User;
import com.leal.store.repositores.UserRepository;
import com.leal.store.services.exception.DatabaseException;
import com.leal.store.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {

        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        User entity = userRepository.getReferenceById(id);
        updateDate(obj, entity);
        return userRepository.save(entity);
    }

    private void updateDate(User obj, User entity) {
        entity.setUsername(obj.getUsername());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
