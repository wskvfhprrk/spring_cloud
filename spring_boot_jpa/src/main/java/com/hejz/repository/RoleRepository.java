package com.hejz.repository;

import com.hejz.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 14:12
 */
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
}
