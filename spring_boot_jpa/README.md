# Spring boot jpa

> 使用spring boot、spring data jpa、druid数据监控，对user进行CURD操作，分页查询，使用jpa自动创建时间或更新时间使用`@EnableJpaAuditing`

## `application.yml`配置

```yaml
spring:
  application:
    name: springBootJpa
  datasource:
    url: jdbc:mysql://192.168.200.131:3306/spring_boot_jpa?autoReconnect=true&useSSL=false&characterEncoding=utf-8
    username: root
    password: 123456
    driver-class-name: com.mysql.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

## `DruidConfig`配置

详见项目——可更改密码