package com.maomao.mybatisplus.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.maomao.mybatisplus.mybatisplus.**.mapper*", "com.maomao.mybatisplus.mybatisplus.mysql.mapper"})
public class MybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusApplication.class, args);
	}

}
