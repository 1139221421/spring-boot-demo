package com.lxl.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author lixiaolong
 * @Description: 用于spring-boot配置文件直接赋值的对象封装
 * @Date 2018/3/16
 */
@Component
@ConfigurationProperties(prefix = "person")//读取前缀为person的配置
public class Person {

    private Integer id;

    private String gender;

    private Integer age;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
