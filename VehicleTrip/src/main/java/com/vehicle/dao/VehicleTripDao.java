package com.vehicle.dao;

import java.util.List;

import com.vehicle.model.VehicleTripInfo;

public interface VehicleTripDao {

	/**
	 * 
	 * Saving info of vehicle
	 * 
	 * @param info
	 * @return
	 */
	VehicleTripInfo saveVehicleTrip(VehicleTripInfo info);

	/**
	 * Retrieving info of vehicle
	 * 
	 * @param vehicleId
	 * @return
	 */
	List<VehicleTripInfo> getVehicleList(long vehicleId);

	List<VehicleTripInfo> getAllVehicleTripInfo();
}
