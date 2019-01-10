package com.vehicle.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dao.VehicleTripDao;
import com.vehicle.model.VehicleTripInfo;
import com.vehicle.service.VehicleTripService;

@Service
public class VehicleTripServiceImpl implements VehicleTripService {

	private static final Logger Logger = LoggerFactory.getLogger(VehicleTripServiceImpl.class);

	@Autowired
	VehicleTripDao vehicleTripDao;

	@Override
	public List<VehicleTripInfo> getVehicleTripInfo(long vehicleNo) {
		Logger.info("Enter getVehicleTripInfo: Param # " + vehicleNo);
		return vehicleTripDao.getVehicleList(vehicleNo);
	}

	@Override
	public List<VehicleTripInfo> getAllVehicleTripInfo() {
		Logger.info("Enter getAllVehicleTripInfo");
		return vehicleTripDao.getAllVehicleTripInfo();
	}

}
