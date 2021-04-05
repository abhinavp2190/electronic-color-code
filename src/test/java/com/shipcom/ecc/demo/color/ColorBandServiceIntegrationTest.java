package com.shipcom.ecc.demo.color;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ColorBandServiceIntegrationTest {
	
	@Autowired
    private ColorBandService colorBandService;

	@Test
    public void whenValidColor_thenColorBandShouldBeFound() {
        String color = "BLACK";
        List<ColorBand> found = colorBandService.getColor(color);
        
        System.out.println(found);
     
         assertThat(found.get(0).getColor())
          .isEqualTo(color);
     }

}
