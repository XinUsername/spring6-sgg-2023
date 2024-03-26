package com.cjx.core;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCoreApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringBootCoreApplication.class, args);
		SpringApplication application = new SpringApplication(SpringBootCoreApplication.class);
		//参数设置
//		application.addListeners();

		application.run(args);
	}

	@Bean
	public ApplicationRunner applicationRunner(){
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				System.out.println("===ApplicationRunner 运行了...");
			}
		};
	}

	//lambda 写法
	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			System.out.println("===CommandLineRunner 运行了...");
		};
	}

}
