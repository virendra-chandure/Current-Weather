package com.example.weather.service;

import java.util.List;

import com.example.weather.model.Location;
import com.example.weather.model.Weather;

public interface WeatherService {
	public Weather getWeather(String country, String city);

	public List<Location> getLocations();
}
