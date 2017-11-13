package com.example.weather.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.model.Location;
import com.example.weather.model.Weather;
import com.example.weather.model.WeatherSummary;
import com.example.weather.service.WeatherService;
import com.example.weather.util.WeatherTranslator;

@RestController
public class UIController {

	WeatherService weatherService;

	public UIController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@GetMapping("/locations")
	@ResponseBody
	public Map<String, Object> cityList() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Location> locations = weatherService.getLocations();
		model.put("locations", locations);
		return model;
	}

	@GetMapping("/summary/{country}/{city}")
	@ResponseBody
	public Map<String, Object> summary(@PathVariable String country, @PathVariable String city) {
		Map<String, Object> model = new HashMap<String, Object>();
		Weather weather = new Weather();
		weather = weatherService.getWeather(country, city);
		WeatherSummary weatherSummary = WeatherTranslator.convertWeather(city, weather);
		model.put("summary", weatherSummary);
		return model;
	}

}
