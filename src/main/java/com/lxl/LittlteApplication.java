package com.lxl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//    1.  需要设置事务(本质也是AOP)执行的顺序，否则事务的执行顺序高于后续的AOP，会导致动态切换数据源失效
//   2. exclude = {DataSourceAutoConfiguration.class}用于禁用掉默认的数据源获取方式，默认会读取配置文件的据源（spring.datasource.*）
//    3. MapperScan()指向的是mapper
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement(order = 2) //设置事务执行顺序(需要在切换数据源之后，否则只走默认库)
@ServletComponentScan
@EnableCaching//开启缓存
@MapperScan(basePackages = {"com.lxl.mapper"}) //就不用再每个mapper配置@Mapper
public class LittlteApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittlteApplication.class, args);
    }
}
