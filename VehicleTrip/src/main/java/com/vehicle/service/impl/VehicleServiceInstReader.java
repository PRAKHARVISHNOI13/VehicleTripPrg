package com.vehicle.service.impl;

import java.util.concurrent.BlockingQueue;

import com.vehicle.model.VehicleInst;

public class VehicleServiceInstReader implements Runnable {

	private BlockingQueue<VehicleInst> queue;
	private VehicleInfoProcesser processVehicleInfo;

	public VehicleServiceInstReader(BlockingQueue<VehicleInst> queue, VehicleInfoProcesser processVehicleInfo) {
		super();
		this.queue = queue;
		this.processVehicleInfo = processVehicleInfo;
	}

	@Override
	public void run() {
		try {
			while (!queue.isEmpty()) {
				VehicleInst vi = queue.take();
				// System.out.println("Consumed >>>>> " + vi + " >>>>> "+ new Date());
				processVehicleInfo.processVehicleInfoToSave(vi);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
