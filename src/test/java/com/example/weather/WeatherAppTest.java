package com.example.weather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WeatherAppTest {

	@LocalServerPort
	private int port;

	@Test
	public void homePageLoad() {
		ResponseEntity<String> response = new TestRestTemplate().getForEntity("http://localhost:" + port + "/",
				String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}