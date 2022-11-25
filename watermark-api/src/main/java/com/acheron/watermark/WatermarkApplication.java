package com.acheron.watermark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.acheron.watermark.service.IWatermarkService;

/**
 * @author MohammedRinishA
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WatermarkApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(WatermarkApplication.class, args);
	}

	IWatermarkService watermarkService;
	
	
	@Autowired
	public void setWatermarkService(IWatermarkService watermarkService) {
		this.watermarkService = watermarkService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		
		
	}

}
