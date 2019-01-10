package com.vehicle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.mapper.ResponseObjectMapperUtil;
import com.vehicle.model.VehicleTripInfo;
import com.vehicle.model.VehicleTripInfoDto;
import com.vehicle.service.VehicleTripService;

@RestController("vehicleInfoController")
public class VehicleInfoController {

	private static final Logger Logger = LoggerFactory.getLogger(VehicleInfoController.class);

	@Autowired
	VehicleTripService vehicleTripService;

	/**
	 *
	 * Method to retrieve the data for trip detail
	 *
	 * @param vehicleId
	 * @return
	 */
	@GetMapping("/vehicleInfo/{vehicleId}")
	public Object getVehicleTripInfo(@PathVariable long vehicleId) {
		Logger.info("Enter VehicleInfoController method getVehicleTripInfo: Param # " + vehicleId);
		List<VehicleTripInfo> vehicleTripInfo = vehicleTripService.getVehicleTripInfo(vehicleId);
		List<VehicleTripInfoDto> vehicleTripInfoDtos = ResponseObjectMapperUtil.getMappedDtos(vehicleTripInfo);
		return new ResponseEntity<List<VehicleTripInfoDto>>(vehicleTripInfoDtos, HttpStatus.OK);
	}

	@GetMapping("/vehicleInfo/all")
	public Object getAllVehicleTripInfo() {
		Logger.info("Enter VehicleInfoController method getAllVehicleTripInfo: Param # ");
		List<VehicleTripInfo> vehicleTripInfo = vehicleTripService.getAllVehicleTripInfo();
		List<VehicleTripInfoDto> vehicleTripInfoDtos = ResponseObjectMapperUtil.getMappedDtos(vehicleTripInfo);
		return new ResponseEntity<List<VehicleTripInfoDto>>(vehicleTripInfoDtos, HttpStatus.OK);
	}

}
