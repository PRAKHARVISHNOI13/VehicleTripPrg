package com.vehicle.model;

public class VehicleTripInfoDto {
	private long vehicleId;
	private int tripNo;
	private int tripDuration;

	public VehicleTripInfoDto() {
		super();
	}

	public VehicleTripInfoDto(long vehicleId, int tripNo, int tripDuration) {
		super();
		this.vehicleId = vehicleId;
		this.tripNo = tripNo;
		this.tripDuration = tripDuration;
	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getTripNo() {
		return tripNo;
	}

	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}

	public int getTripDuration() {
		return tripDuration;
	}

	public void setTripDuration(int tripDuration) {
		this.tripDuration = tripDuration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tripDuration;
		result = prime * result + tripNo;
		result = prime * result + (int) (vehicleId ^ (vehicleId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleTripInfoDto other = (VehicleTripInfoDto) obj;
		if (tripDuration != other.tripDuration)
			return false;
		if (tripNo != other.tripNo)
			return false;
		if (vehicleId != other.vehicleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VehicleTripInfoDto [vehicleId=" + vehicleId + ", tripNo=" + tripNo + ", tripDuration=" + tripDuration + "]";
	}

}
