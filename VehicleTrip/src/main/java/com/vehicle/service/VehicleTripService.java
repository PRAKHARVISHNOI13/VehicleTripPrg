package com.vehicle.service;

import java.util.List;

import com.vehicle.model.VehicleTripInfo;

public interface VehicleTripService {

	/**
	 * Service layer for retrieving data
	 * 
	 * @param vehicleId
	 * @return
	 */
	List<VehicleTripInfo> getVehicleTripInfo(long vehicleId);

	List<VehicleTripInfo> getAllVehicleTripInfo();
}
