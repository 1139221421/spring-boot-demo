package com.lxl.controller;

import com.alibaba.fastjson.JSONArray;
import com.lxl.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/16
 */
@RestController
public class TestController {
    @Value("${gender}")
    private String gender;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private Person person;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return content;
    }

    @RequestMapping(value = {"/person", "/people"}, method = RequestMethod.GET)
    public String person() {
        return JSONArray.toJSONString(person);
    }


    //处理参数
    //    @PathVariable 获取url中参数
    //    @RequestParam 获取请求参数的值

    //url:http://localhost:8000/little/person/1
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public String personIdRight(@PathVariable("id") Integer id) {
        return "id:" + id;
    }

    //url:http://localhost:8000/little/2/person/
    @RequestMapping(value = "{id}/person", method = RequestMethod.GET)
    public String personIdLeft(@PathVariable(value = "id") Integer id) {
        return "id:" + id;
    }

    //传统url
    @RequestMapping(value = "/personId", method = RequestMethod.GET)
    //不是必须要求，默认为0
    public String personIdRequestParam(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id) {
        return "id:" + id;
    }

    //传统url
    @GetMapping("personId2")
//    @PostMapping 都是组合注解
//    @PutMapping
    //不是必须要求，默认为0
    public String GetMapping(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id) {
        return "id:" + id;
    }


}
