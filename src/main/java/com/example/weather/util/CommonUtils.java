package com.example.weather.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class CommonUtils {

	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE hh:mm a");
	private static final String TEMP_FORMAT = "%4.2f\u00b0C";
	private static final String WIND_FORMAT = "%4.2f km/ph";

	public static String getFormattedDate(Date date) {
		return dateFormatter.format(date);
	}

	public static String getFormattedDate(Instant instant) {
		return getFormattedDate(Date.from(instant));
	}

	public static double convertMpsToKmph(double mps) {
		return (mps * 18) / 5;
	}

	public static String formatSpeed(double mps) {
		return String.format(WIND_FORMAT, convertMpsToKmph(mps));
	}

	public static double toCelcius(double kelvinTemp) {
		return kelvinTemp - 273.0;
	}

	public static String formatTemparature(double temp) {
		return String.format(TEMP_FORMAT, toCelcius(temp));
	}

}
