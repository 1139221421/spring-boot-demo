package com.lxl.service;

import com.lxl.config.DataSourceType;
import com.lxl.config.MyDataSource;
import com.lxl.dao.TestUserDao;
import com.lxl.dao.TestUserRepository;
import com.lxl.mapper.PeopleMapper;
import com.lxl.vo.People;
import com.lxl.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/16
 */
@Service
//@CacheConfig(cacheNames = "peoples")
public class TestUserService {

    @Autowired
    private TestUserRepository userRepository;//hibernate jpa实现方式

    @Autowired
    private TestUserDao testUserDao;//hibernate jdbctemplate实现

    @Autowired
    private PeopleMapper peopleMapper;//mybatis实现

    //jpa实现方式测试
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void saveTwo() {
        User user1 = new User("事物1", "事物1");
        User user2 = new User("事物2222222222222222222222", "事物2");
        userRepository.save(user1);
        userRepository.save(user2);
    }

    public User findById(Integer id) {
        return userRepository.findById(id);
    }
    //jpa测试结束

    //jdbctemplate测试
    public User findUserByName(String name) {
        return testUserDao.findUserByName(name);
    }

    //mybatis测试方法
    public void add(People people) {
        peopleMapper.add(people);
    }

    //多数据源测试 和缓存测试
    @MyDataSource(DataSourceType.Master)
    @Cacheable(key = "'id:'+#p0", value = "peoples")
    public People getPeopleByid(String id) {
        System.out.println("查询数据库");
        return peopleMapper.getPeopleById(id);
    }

    @CachePut(key = "'id:'+#p0.id", value = "peoples")
    public People update(People people) throws Exception {
        peopleMapper.update(people);
        return people;
    }

    @CacheEvict(key = "'id:'+#p0", value = "peoples")
    public void delete(String id) {
        peopleMapper.delete(id);
    }

}
