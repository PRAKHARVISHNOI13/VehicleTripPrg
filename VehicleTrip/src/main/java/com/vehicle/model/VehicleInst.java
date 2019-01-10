package com.vehicle.model;

public class VehicleInst {

	private String vehicleId;
	private String event;

	public VehicleInst() {
		super();
	}

	public VehicleInst(String vehicleId, String event) {
		super();
		this.vehicleId = vehicleId;
		this.event = event;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return vehicleId + "," + event;
	}

}
