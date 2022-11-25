package com.acheron.watermark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WatermarkCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatermarkCloudGatewayApplication.class, args);
	}

}
