package com.lxl.config;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/20
 */
public enum DataSourceType {
    // 主表
    Master("master"),
    Slave("slave");

    private String name;

    private DataSourceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
