package com.shipcom.ecc.demo.color;

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
public class ColorBandControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testGetAllColor() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(
			MockMvcRequestBuilders.get("/colors/")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		String expected = "[{\"id\":1,\"color\":\"BLACK\",\"value\":0},{\"id\":2,\"color\":\"BROWN\",\"value\":1},{\"id\":3,\"color\":\"RED\",\"value\":2},{\"id\":4,\"color\":\"ORANGE\",\"value\":3},{\"id\":5,\"color\":\"YELLOW\",\"value\":4},{\"id\":6,\"color\":\"GREEN\",\"value\":5},{\"id\":7,\"color\":\"BLUE\",\"value\":6},{\"id\":8,\"color\":\"VIOLET\",\"value\":7},{\"id\":9,\"color\":\"GREY\",\"value\":8},{\"id\":10,\"color\":\"WHITE\",\"value\":9}]";
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}
}
