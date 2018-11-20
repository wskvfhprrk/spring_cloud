package com.hejz.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 13:52
 */
@Entity
@Table(name = "permission")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
    @TableGenerator(name = "sequence", initialValue = 0, allocationSize = 1)
    private Long id;
    private String permission;
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

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
