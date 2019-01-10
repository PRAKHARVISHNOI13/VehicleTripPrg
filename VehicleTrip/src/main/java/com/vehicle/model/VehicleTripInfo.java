package com.vehicle.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "vehicle_trip_info")
public class VehicleTripInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "VEHICLE_ID")
	private long vehicleId;

	@Column(name = "TRIP_NO")
	private int tripNo;

	@Column(name = "TRIP_DURATION")
	private int tripDuration;

	@Transient
	private String inst;

	@Transient
	private Date stTimes;

	public VehicleTripInfo() {
		super();
	}

	public VehicleTripInfo(int vehicleId, int tripNo, int tripDuration) {
		super();
		this.vehicleId = vehicleId;
		this.tripNo = tripNo;
		this.tripDuration = tripDuration;
	}

	public Date getStTimes() {
		return stTimes;
	}

	public void setStTimes(Date stTimes) {
		this.stTimes = stTimes;
	}

	public String getInst() {
		return inst;
	}

	public void setInst(String inst) {
		this.inst = inst;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getTripNo() {
		return tripNo;
	}

	public void setTripNo(Integer tripNo) {
		this.tripNo = tripNo;
	}

	public Integer getTripDuration() {
		return tripDuration;
	}

	public void setTripDuration(Integer tripDuration) {
		this.tripDuration = tripDuration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		VehicleTripInfo other = (VehicleTripInfo) obj;
		if (id != other.id)
			return false;
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
		return "VehicleTripInfo [vehicleId=" + vehicleId + ", tripNo=" + tripNo + ", tripDuration=" + tripDuration + "]";
	}

}
