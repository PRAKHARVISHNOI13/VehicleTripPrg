package com.vehicle.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dao.VehicleTripDao;
import com.vehicle.model.VehicleInst;
import com.vehicle.model.VehicleTripInfo;

@Service
public class VehicleInfoProcesser {

	@Autowired
	VehicleTripDao vehicleTripDao;

	private static volatile Map<String, VehicleTripInfo> vehicleInfo = new HashMap<>();

	public void processVehicleInfoToSave(VehicleInst vehicleInst) {

		if (vehicleInst.getEvent().equals("START")) {
			VehicleTripInfo vehicleTripInfo = new VehicleTripInfo();
			vehicleTripInfo.setVehicleId(Integer.parseInt(vehicleInst.getVehicleId()));
			vehicleTripInfo.setInst(vehicleInst.getEvent());
			if (vehicleInfo.get(vehicleInst.getVehicleId()) != null)
				vehicleTripInfo.setTripNo(vehicleInfo.get(vehicleInst.getVehicleId()).getTripNo());
			else
				vehicleTripInfo.setTripNo(0);
			vehicleTripInfo.setTripDuration(0);
			vehicleTripInfo.setStTimes(new Date());
			vehicleInfo.put(vehicleInst.getVehicleId(), vehicleTripInfo);
		}
		if (vehicleInst.getEvent().equals("STOP")) {
			VehicleTripInfo vehicleTripInfo = vehicleInfo.get(vehicleInst.getVehicleId());
			long diffInMillies = new Date().getTime() - vehicleTripInfo.getStTimes().getTime();
			vehicleTripInfo.setTripDuration((int) diffInMillies);
			vehicleTripInfo.setTripNo(vehicleTripInfo.getTripNo() + 1);
			vehicleTripInfo.setInst(vehicleInst.getEvent());
			vehicleInfo.put(vehicleInst.getVehicleId(), vehicleTripInfo);

			vehicleInfo.keySet().forEach(key -> {
				VehicleTripInfo vehicleTripIn = vehicleInfo.get(key);
				if (vehicleTripIn.getInst().equals("STOP") && key.equals(vehicleInst.getVehicleId())) {
					vehicleTripDao.saveVehicleTrip(vehicleTripIn);
				}
			});
		}
	}

}
