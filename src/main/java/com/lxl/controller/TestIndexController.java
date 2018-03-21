package com.lxl.controller;

import com.lxl.util.ActionUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @Author lixiaolong
 * @Description:页面跳转
 * @Date 2018/3/16
 */
@Controller
public class TestIndexController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        map.put("index", "首页！！！");
        return ActionUrl.INDEX_TEST;
    }
}
