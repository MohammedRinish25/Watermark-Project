package com.watermark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WaterMarkEurekaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaterMarkEurekaRegistryApplication.class, args);
	}

}
