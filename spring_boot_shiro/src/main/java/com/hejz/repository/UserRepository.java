package com.hejz.repository;

import com.hejz.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 14:01
 */
public interface UserRepository extends JpaRepository<User,Long> , JpaSpecificationExecutor<User> {
    User findByUsername(String username);

    Page<User> findAll(Specification<User> sort, Pageable pageable);
}
