package com.vehicle.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.vehicle.model.VehicleTripInfo;
import com.vehicle.model.VehicleTripInfoDto;

public class ResponseObjectMapperUtil {

	public static List<VehicleTripInfoDto> getMappedDtos(List<VehicleTripInfo> vehicleTripInfo) {
		return vehicleTripInfo.stream().map(vehicleTripInfoToVehicleTripInfoDto).collect(Collectors.<VehicleTripInfoDto>toList());
	}

	public static Function<VehicleTripInfo, VehicleTripInfoDto> vehicleTripInfoToVehicleTripInfoDto = (vehicleTripInfo) -> {
		VehicleTripInfoDto vehicleTripInfoDto = new VehicleTripInfoDto();
		vehicleTripInfoDto.setVehicleId(vehicleTripInfo.getVehicleId());
		vehicleTripInfoDto.setTripNo(vehicleTripInfo.getTripNo());
		vehicleTripInfoDto.setTripDuration(vehicleTripInfo.getTripDuration());
		return vehicleTripInfoDto;
	};
}
