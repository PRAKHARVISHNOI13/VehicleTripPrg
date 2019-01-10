package com.vehicle.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vehicle.controller.VehicleInfoController;
import com.vehicle.model.VehicleTripInfo;
import com.vehicle.repository.VehicleTripRepository;
import com.vehicle.service.VehicleTripService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleRepositoryTest {
	@Autowired
	private VehicleTripRepository vehicleTripRepository;

	@Autowired
	VehicleTripService vehicleTripService;
	
	
	// Testing DB and retrieval
	@Test
	public void whenFindingVehicleById_thenCorrect() {
		vehicleTripRepository.save(new VehicleTripInfo(1, 2, 13221));
		Optional<VehicleTripInfo> cust = vehicleTripRepository.findById(1L);
		assertThat(vehicleTripRepository.findById(1L)).isInstanceOf(Optional.class);
		assertEquals(Integer.parseInt("13221"), Integer.parseInt(cust.get().getTripDuration().toString()));
	}

	
	// Testing Service and DB
	@Test
	public void whenFindingVehicleInformationById_thenCorrect() {
		vehicleTripRepository.save(new VehicleTripInfo(1, 1, 13221));
		vehicleTripRepository.save(new VehicleTripInfo(1, 2, 11111));
		assertThat(vehicleTripService.getVehicleTripInfo(1)).isInstanceOf(List.class);
	}

}
