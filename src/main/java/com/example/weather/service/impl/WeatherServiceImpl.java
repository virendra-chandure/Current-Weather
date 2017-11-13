package com.example.weather.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.example.weather.model.Location;
import com.example.weather.model.Weather;
import com.example.weather.service.WeatherService;
import com.example.weather.util.WeatherAppProperties;

@Service
public class WeatherServiceImpl implements WeatherService {

	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
	private final RestTemplate restTemplate;
	private final List<String> locations;
	private final String apiUrl;
	private final String apiKey;

	public WeatherServiceImpl(RestTemplate restTemplate, WeatherAppProperties properties) {
		this.restTemplate = restTemplate;
		this.locations = properties.getLocations();
		this.apiUrl = properties.getApi().getUrl();
		this.apiKey = properties.getApi().getKey();
	}

	public Weather getWeather(String country, String city) {
		logger.info("Requesting current weather for {}/{}", country, city);
		URI url = new UriTemplate(this.apiUrl).expand(city, country, this.apiKey);
		return invoke(url, Weather.class);
	}

	@Override
	public List<Location> getLocations() {
		List<Location> locations = new ArrayList<Location>();
		for (String location : this.locations) {
			String[] pair = location.split("/");
			locations.add(new Location(pair[0], pair[1]));
		}
		return locations;
	}

	private <T> T invoke(URI url, Class<T> responseType) {
		RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
		return exchange.getBody();
	}

}
