package com.example.tp1.Service;


import com.example.tp1.Entity.Role;
import com.example.tp1.Entity.User;
import com.example.tp1.Repository.RoleRepository;
import com.example.tp1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void AddRoleToUser(String username, String RoleName) {

    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> listUsers() {
        return null;
    }
}
