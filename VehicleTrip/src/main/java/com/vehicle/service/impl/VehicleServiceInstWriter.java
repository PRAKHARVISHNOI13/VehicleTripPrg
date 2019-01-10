package com.vehicle.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import com.vehicle.model.VehicleInst;

public class VehicleServiceInstWriter implements Runnable {

	private BlockingQueue<VehicleInst> queue;
	private String filePath;
	private volatile Integer startCount = 0;
	private volatile Integer endCount = 4;

	public VehicleServiceInstWriter(BlockingQueue<VehicleInst> queue, String filePath) {
		super();
		this.queue = queue;
		this.filePath = filePath;
	}

	@Override
	public void run() {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			for (int i = 0; i < startCount + 4; i++) {
				if (i >= startCount && i < endCount) {
					String line = br.readLine();
					String[] vehicleData = line.split(",");
					queue.put(new VehicleInst(vehicleData[0], vehicleData[1]));
				} else {
					String dumm = br.readLine();
				}
			}
			startCount += 4;
			endCount += 4;

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
