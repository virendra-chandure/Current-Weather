package com.example.weather.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Weather implements Serializable {

	private static final long serialVersionUID = -4257887053238497349L;

	private Instant timestamp;

	private double temperature;

	private double wind;

	private String description;

	@JsonProperty("timestamp")
	public Instant getTimestamp() {
		return this.timestamp;
	}

	@JsonSetter("dt")
	public void setTimestamp(long unixTime) {
		this.timestamp = Instant.ofEpochMilli(unixTime * 1000);
	}

	public double getTemperature() {
		return this.temperature;
	}

	@JsonProperty("main")
	public void setTemperature(Map<String, Object> main) {
		temperature = Double.parseDouble(main.get("temp").toString());
	}

	public String getDescription() {
		return description;
	}

	@JsonProperty("weather")
	public void setDescription(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		description = (String) weather.get("main")+", "+ (String) weather.get("description");
	}

	public double getWind() {
		return wind;
	}

	@JsonSetter("wind")
	public void setWind(Map<String, Object> wind) {
		this.wind = Double.parseDouble(wind.get("speed").toString());
	}

}
