package com.lxl.test;

import com.alibaba.fastjson.JSONArray;
import com.lxl.service.TestUserService;
import com.lxl.vo.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author lixiaolong
 * @Description:测试类
 * @Date 2018/3/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserServiceTest {
    @Autowired
    private TestUserService testUserService;

    @Test
    public void getPeopleByid() {
        System.out.println(JSONArray.toJSONString(testUserService.getPeopleByid("4")));
    }

    @Test
    public void add() throws Exception {
        People people = new People();
        people.setUser_name("hahah11111");
        testUserService.add(people);
    }

    @Test
    public void update() throws Exception {
        People people = new People();
        people.setId("3");
        people.setUser_name("222");
        testUserService.update(people);
    }

    @Test
    public void delete() {
        testUserService.delete("4");
    }


}
