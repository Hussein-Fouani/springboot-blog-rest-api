package com.hf.springbootblogrestapi.repository;

import com.hf.springbootblogrestapi.entity.ROLE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<ROLE,Long> {

    Optional<ROLE> findByROLE_NAME(String name);
}
