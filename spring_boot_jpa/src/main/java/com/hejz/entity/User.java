package com.hejz.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 13:49
 */
@Entity
@Table(name = "user")
@Data
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
    @TableGenerator(name = "sequence", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String username;
    private String name;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Role> roles;

    // 创建人
    @CreatedBy
    private String createBy;
    // 更新人
    @LastModifiedBy
    private String updateBy;
    // 创建时间
    @CreatedDate
    @Column(nullable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP", updatable = false)
    private Date createAt;
    // 更新时间
    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateAt;
}