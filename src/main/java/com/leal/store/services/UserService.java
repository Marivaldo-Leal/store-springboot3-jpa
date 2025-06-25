package com.leal.store.services;

import com.leal.store.entities.User;
import com.leal.store.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return userRepository.findById(id).get();
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
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
