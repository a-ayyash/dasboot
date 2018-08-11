package com.learning.dasboot;

import com.learning.dasboot.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DasbootApplicationTests {

	@Test
	public void contextLoads() {
        HomeController hc = new HomeController();
        String str = hc.index();
        assertEquals(str, "Hello");
	}

}
