package com.example.tp1.Service;


import com.example.tp1.Entity.Role;
import com.example.tp1.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    User addUser(User user);
    Role addRole (Role role);

    public void AddRoleToUser (String username,String RoleName);

    User loadUserByUsername(String username);
    List<User> listUsers();
}
