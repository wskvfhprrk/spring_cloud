package com.hejz.repository;

import com.hejz.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 何建哲
 * @date 2018/11/20 10:21
 */
public interface PermissionRepository  extends JpaRepository<Permission,Long> , JpaSpecificationExecutor<Permission> {
}
