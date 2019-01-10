package com.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vehicle.service.impl.WriterReaderService;

@SpringBootApplication
public class VehicleTripApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext startApp = SpringApplication.run(VehicleTripApplication.class, args);
		WriterReaderService pcs = (WriterReaderService) startApp.getBean("writerReaderService");
		pcs.startApp();
	}

}
