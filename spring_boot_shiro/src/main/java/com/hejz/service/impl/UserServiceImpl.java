package com.hejz.service.impl;

import com.hejz.dto.UserDto;
import com.hejz.dto.UserPageDto;
import com.hejz.dto.UserSearchDto;
import com.hejz.entity.User;
import com.hejz.repository.UserRepository;
import com.hejz.service.UserService;
import com.hejz.util.MD5Util;
import com.hejz.util.RestCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 何建哲
 * @date 2018/11/20 10:26
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public RestCode saveUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        try {
            //加密
            String password= MD5Util.getPassword(user.getUsername(),user.getPassword());
            user.setPassword(password);
            User user1 = userRepository.save(user);
            return RestCode.ok(user1);
        } catch (DataIntegrityViolationException e) {
            return RestCode.error("username已经存在");
        } catch (Exception e) {
            e.printStackTrace();
            return RestCode.error(e.getMessage());
        }
    }

    @Override
    public RestCode updateUser(UserDto userDto) {
        if (userDto.getId() == null || userDto.getId() == 0) {
            return RestCode.error("id值不能为空");
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        try {
            //加密
            String password= MD5Util.getPassword(user.getUsername(),user.getPassword());
            user.setPassword(password);
            User user1 = userRepository.save(user);
            return RestCode.ok(user1);
        } catch (Exception e) {
            e.printStackTrace();
            return RestCode.error(e.getMessage());
        }
    }

    @Override
    public RestCode deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
            return RestCode.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return RestCode.error(e.getMessage());
        }
    }

    @Override
    public RestCode findUserPage(UserPageDto userPageDto) {
        UserSearchDto userSearchDto = new UserSearchDto();
        BeanUtils.copyProperties(userSearchDto, userPageDto);
        Specification<User> sort = getSpecification(userSearchDto);
        Pageable pageable = PageRequest.of(userPageDto.getPage(), userPageDto.getSize());
        Page<User> userPage = userRepository.findAll(sort, pageable);
        return RestCode.ok(userPage);
    }

    private Specification<User> getSpecification(UserSearchDto userSearchDto) {
        Specification<User> sort = (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (StringUtils.isNotBlank(userSearchDto.getName())) {
                predicateList.add(criteriaBuilder.equal(root.get("name"), userSearchDto.getName()));
            }
            if (StringUtils.isNotBlank(userSearchDto.getUsername())) {
                predicateList.add(criteriaBuilder.equal(root.get("username"), userSearchDto.getUsername()));
            }

            Predicate[] p = new Predicate[predicateList.size()];
            criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(p)));
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createAt")));
            return criteriaQuery.getRestriction();
        };
        return sort;
    }
}
