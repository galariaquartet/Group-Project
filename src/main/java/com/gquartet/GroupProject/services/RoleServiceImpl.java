/*
 * Created on 12/04/2020 at 22:32:53 GMT+2
 */
package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Role;
import com.gquartet.GroupProject.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getCustomerRole() {
        return roleRepository.findByRoleId(2);
    }

}
