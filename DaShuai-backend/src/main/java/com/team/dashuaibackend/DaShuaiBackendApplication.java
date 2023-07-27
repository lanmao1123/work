package com.team.dashuaibackend;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.team.dashuaibackend.mapper")
public class DaShuaiBackendApplication {

    public static void main(String[] args) {
        System.out.println("你好！ 大帅");
        SpringApplication.run(DaShuaiBackendApplication.class, args);
    }

}
