package com.lxl.controller;

import com.lxl.service.TestUserService;
import com.lxl.vo.People;
import com.lxl.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/16
 */
@RestController
public class TestUserController {

    @Autowired
    private TestUserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/save")
    public User save(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return userService.save(user);
    }

    //JpaReposity
    @GetMapping("/savetwo")
    public void saveTwo() {
        userService.saveTwo();
    }

    //jdbctemplate  有mysql-connector-java,spring-boot-starter-data-jpa依赖就行了
    @GetMapping("/findbyname")
    public User findUserByName() {
        return userService.findUserByName("111");
    }

    //实现JpaReposity和jdbctemplate接口， jdbctemplate接口实现了自定义curd方法
    @GetMapping("/findbyid")
    public User findById() {
        return userService.findById(1);
    }

    @GetMapping("/getpeople")
    public People getpeople() {
        return userService.getPeopleByid("2");
    }


}
