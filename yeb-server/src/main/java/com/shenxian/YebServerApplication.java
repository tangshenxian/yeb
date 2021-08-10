package com.shenxian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: shenxian
 * @Date: 2021/7/17 15:22
 */
@SpringBootApplication
@MapperScan("com.shenxian.mapper")
public class YebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YebServerApplication.class, args);
    }

}
