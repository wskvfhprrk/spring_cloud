package com.example.shiro.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 13:52
 */
@Entity
@Data
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String permission;
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

}
