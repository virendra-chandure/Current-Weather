package com.example.weather.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class CommonUtilsTest {
	
	private Date getSampleDate() {
		try {
			return new SimpleDateFormat("dd/mm/yyyy HH:mm").parse("14/11/2017 08:30");
		} catch (ParseException e) {
			return new Date();
		}
	}

	@Test
	public void testGetFormattedDate1() {
		assertEquals("Saturday 08:30 AM", CommonUtils.getFormattedDate(getSampleDate().toInstant()));
	}
	@Test
	public void testGetFormattedDate2() {
		assertEquals("Saturday 08:30 AM", CommonUtils.getFormattedDate(getSampleDate()));
	}
	@Test
	public void testConvertMsToKmph() {
		assertEquals(15.599999999879998, CommonUtils.convertMpsToKmph(4.3333333333),0);
	}
	@Test
	public void testFormatSpeed() {
		assertEquals("15.60 km/ph", CommonUtils.formatSpeed(4.3333333333));
	}
	@Test
	public void testToCelcius() {
		assertEquals(13.166666666000026, CommonUtils.toCelcius(286.166666666),0);
	}
	@Test
	public void testFormatTemparature() {
		assertEquals("13.17\u00b0C", CommonUtils.formatTemparature(286.166666666));
	}

}
