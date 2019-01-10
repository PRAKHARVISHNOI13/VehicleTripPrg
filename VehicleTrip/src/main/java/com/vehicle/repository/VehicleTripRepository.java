package com.vehicle.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.model.VehicleTripInfo;

@Repository("vehicleTripRepository")
public interface VehicleTripRepository extends CrudRepository<VehicleTripInfo, Long> {

	List<VehicleTripInfo> findByVehicleId(long vehicleId);
	
	List<VehicleTripInfo> findAll();

}
