package com.lxl.dao;

import com.lxl.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/16
 */
public interface TestUserRepository extends JpaRepository<User,Integer>,TestMyDao {

}
