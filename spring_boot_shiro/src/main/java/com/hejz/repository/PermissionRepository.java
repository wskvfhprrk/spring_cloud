package com.hejz.repository;

import com.hejz.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 何建哲
 * @date 2018/11/20 14:59
 */
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
