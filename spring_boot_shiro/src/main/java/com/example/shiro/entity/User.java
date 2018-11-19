package com.example.shiro.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 13:49
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private String name;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Role> roles;
}