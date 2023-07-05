package com.oms.repository;

import com.oms.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Alejandro Fuertes
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
