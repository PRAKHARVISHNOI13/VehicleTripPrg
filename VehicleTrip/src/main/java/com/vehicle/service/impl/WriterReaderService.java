package com.vehicle.service.impl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vehicle.model.VehicleInst;

@Service("writerReaderService")
public class WriterReaderService {

	@Autowired
	VehicleInfoProcesser processVehicleInfo;

	@Value("${file_path}")
	private String filePath;

	@Value("${writer_time_off}")
	private String writerTimeOff;

	@Value("${reader_time_off}")
	private String readerTimeOff;

	@Value("${queue_size}")
	private String queueSize;

	public void startApp() {

		BlockingQueue<VehicleInst> queue = new ArrayBlockingQueue<>(Integer.parseInt(queueSize));

		VehicleServiceInstWriter writer = new VehicleServiceInstWriter(queue, filePath);
		VehicleServiceInstReader reader = new VehicleServiceInstReader(queue, processVehicleInfo);

		ScheduledExecutorService producerService = Executors.newSingleThreadScheduledExecutor();
		producerService.scheduleAtFixedRate(writer, 0, Long.parseLong(writerTimeOff), TimeUnit.MILLISECONDS);

		ScheduledExecutorService consumerService = Executors.newSingleThreadScheduledExecutor();
		consumerService.scheduleAtFixedRate(reader, 0, Long.parseLong(readerTimeOff), TimeUnit.MILLISECONDS);

		System.out.println("Producer and Consumer has been started");
	}

}
