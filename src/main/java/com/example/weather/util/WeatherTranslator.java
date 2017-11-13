package com.example.weather.util;

import com.example.weather.model.Weather;
import com.example.weather.model.WeatherSummary;

public class WeatherTranslator {
	public static WeatherSummary convertWeather(String city, Weather weather) {
		WeatherSummary WeatherSummary = new WeatherSummary();
		WeatherSummary.setCity(city);
		WeatherSummary.setTime(CommonUtils.getFormattedDate(weather.getTimestamp()));
		WeatherSummary.setTemperature(CommonUtils.formatTemparature(weather.getTemperature()));
		WeatherSummary.setWind(CommonUtils.formatSpeed(weather.getWind()));
		WeatherSummary.setWeather(weather.getDescription());
		return WeatherSummary;
	}
}
