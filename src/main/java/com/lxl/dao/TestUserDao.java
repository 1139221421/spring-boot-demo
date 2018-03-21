package com.lxl.dao;

import com.lxl.vo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 通过@Repository注解标注该类为持久化操作对象
 */
@Repository
public class TestUserDao implements TestMyDao {

    // 通过@Resource注解引入JdbcTemplate对象
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 使用JdbcTemplate查询数据步骤:
     * 1. 定义一个sql语句
     * 2. 定义一个RowMapper
     * 3. 执行查询方法
     */
    public User findUserByName(String userName) {
        // 1. 定义一个sql语句
        String querySQL = "select * from user where user_name = ?";
        // 2. 定义一个RowMapper
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        // 3. 执行查询方法
        User user = jdbcTemplate.queryForObject(querySQL, new Object[]{userName}, rowMapper);

        return user;
    }

    @Override
    public User findById(Integer id) {
        // 1. 定义一个sql语句
        String querySQL = "select * from user where id = ?";
        // 2. 定义一个RowMapper
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        // 3. 执行查询方法
        User user = jdbcTemplate.queryForObject(querySQL, new Object[]{id}, rowMapper);

        return user;
    }
}