package com.gquartet.GroupProject.repos;

import com.gquartet.GroupProject.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByRoleId(int roleId);

}
