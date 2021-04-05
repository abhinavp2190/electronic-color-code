package com.shipcom.ecc.demo.multiplier;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shipcom.ecc.demo.ElectronicColorCodeApplication;

@SpringBootTest(
		webEnvironment = WebEnvironment.DEFINED_PORT,
		classes = ElectronicColorCodeApplication.class
	)
	@AutoConfigureMockMvc
	@TestPropertySource(locations = "classpath:application-test.properties")
public class MultiplierControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testGetAllCMultiplier() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(
			MockMvcRequestBuilders.get("/multiplier/")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		String expected = "[{\"id\":1,\"color\":\"PINK\",\"value\":0.001},{\"id\":2,\"color\":\"SILVER\",\"value\":0.01},{\"id\":3,\"color\":\"GOLD\",\"value\":0.1},{\"id\":4,\"color\":\"BLACK\",\"value\":1.0},{\"id\":5,\"color\":\"BROWN\",\"value\":10.0},{\"id\":6,\"color\":\"RED\",\"value\":100.0},{\"id\":7,\"color\":\"ORANGE\",\"value\":1000.0},{\"id\":8,\"color\":\"YELLOW\",\"value\":10000.0},{\"id\":9,\"color\":\"GREEN\",\"value\":100000.0},{\"id\":10,\"color\":\"BLUE\",\"value\":1000000.0},{\"id\":11,\"color\":\"VIOLET\",\"value\":1.0E7},{\"id\":12,\"color\":\"GREY\",\"value\":1.0E8},{\"id\":13,\"color\":\"WHITE\",\"value\":1.0E9}]";
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}

}
