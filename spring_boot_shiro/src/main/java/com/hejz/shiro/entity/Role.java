package com.hejz.shiro.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 13:50
 */
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
    private List<Permission> permissions;

}
