package com.lxl.mapper;

import com.lxl.vo.People;
import org.apache.ibatis.annotations.Param;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/19
 */
//@Mapper
public interface PeopleMapper {

//    @Select("SELECT * FROM people WHERE id = #{id}")//第一种不要mapper.xml
    People getPeopleById(String id);

    void add(@Param("people")People people);

    void update(@Param("people")People people);

    void delete(@Param("id")String id);

}
