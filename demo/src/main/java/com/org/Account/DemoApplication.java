package com.org.Account;

// import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  
public class DemoApplication {

	// private static Object dataSource;
	
		public static void main(String[] args) {
			SpringApplication.run(DemoApplication.class, args);
			
	}

}



