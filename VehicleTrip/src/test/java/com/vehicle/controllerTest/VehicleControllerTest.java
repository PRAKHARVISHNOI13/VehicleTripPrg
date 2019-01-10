package com.vehicle.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.vehicle.controller.VehicleInfoController;
import com.vehicle.model.VehicleTripInfo;
import com.vehicle.service.VehicleTripService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = com.vehicle.VehicleTripApplication.class)
@AutoConfigureMockMvc
public class VehicleControllerTest {

	@Autowired
	public MockMvc springMockMvc;
	@InjectMocks
	protected VehicleInfoController vehicleInfoController;

	@Mock
	VehicleTripService vehicleTripService;

	@Before
	@CacheEvict
	public void init() {
		MockitoAnnotations.initMocks(this);
		springMockMvc = MockMvcBuilders.standaloneSetup(vehicleInfoController).build();
	}

	@Test
	public void getVehicleInfoTest() throws Exception {
		VehicleTripInfo VehicleTripInfo = new VehicleTripInfo(1, 1, 12);
		List<VehicleTripInfo> vehicleTripInfoDtos = new ArrayList<VehicleTripInfo>();
		vehicleTripInfoDtos.add(VehicleTripInfo);
		when(vehicleTripService.getVehicleTripInfo(1)).thenReturn(vehicleTripInfoDtos);
		springMockMvc.perform(get("/vehicleInfo/1")).andExpect(status().isOk());

	}

}
