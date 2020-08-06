package cn.test.controller;

import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Data
public class User implements Serializable {
    private String name;
    private String password;
    private Integer age;

}
