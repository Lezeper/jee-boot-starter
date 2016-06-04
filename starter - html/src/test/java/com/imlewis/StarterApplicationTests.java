package com.imlewis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.imlewis.StarterApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StarterApplication.class)
@WebAppConfiguration
public class StarterApplicationTests {

	@Test
	public void contextLoads() {
	}

}
