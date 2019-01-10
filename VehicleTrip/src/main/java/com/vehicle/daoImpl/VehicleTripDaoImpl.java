package com.vehicle.daoImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dao.VehicleTripDao;
import com.vehicle.model.VehicleTripInfo;
import com.vehicle.repository.VehicleTripRepository;

@Service("vehicleTripDao")
public class VehicleTripDaoImpl implements VehicleTripDao {

	private static final Logger Logger = LoggerFactory.getLogger(VehicleTripDaoImpl.class);

	@Autowired
	private VehicleTripRepository vehicleTripRepository;

	@Override
	public VehicleTripInfo saveVehicleTrip(VehicleTripInfo info) {
		Logger.info("Enter saveVehicleTrip ");
		return vehicleTripRepository.save(info);
	}

	@Override
	public List<VehicleTripInfo> getVehicleList(long vehicleId) {
		Logger.info("Enter getVehicleList # " + vehicleId);
		return (List<VehicleTripInfo>) vehicleTripRepository.findByVehicleId(vehicleId);
	}

	@Override
	public List<VehicleTripInfo> getAllVehicleTripInfo() {
		Logger.info("Enter getAllVehicleTripInfo ");
		return vehicleTripRepository.findAll();
	}

}
