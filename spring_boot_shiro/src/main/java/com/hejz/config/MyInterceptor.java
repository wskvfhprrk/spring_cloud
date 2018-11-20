package com.hejz.config;

import org.hibernate.EmptyInterceptor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;


import org.hibernate.type.Type;


/**
 * @author 何建哲
 * @date 2018/11/20 15:40
 */
public class MyInterceptor extends EmptyInterceptor {

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state,
                          String[] propertyNames, Type[] types) {
        System.out.println("-------------拦截保存-------------");
        System.out.println("entity："+entity);
        System.out.println("id："+id);
        System.out.println("state："+Arrays.toString(state));
        System.out.println("propertyNames："+Arrays.toString(propertyNames));
        System.out.println("types："+Arrays.toString(types));
        return super.onSave(entity, id, state, propertyNames, types);
    }
}