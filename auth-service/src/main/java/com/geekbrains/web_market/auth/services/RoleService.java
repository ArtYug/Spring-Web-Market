package com.geekbrains.web_market.auth.services;

import com.geekbrains.web_market.auth.entities.Role;
import com.geekbrains.web_market.auth.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
