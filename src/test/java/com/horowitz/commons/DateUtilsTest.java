package com.horowitz.commons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class DateUtilsTest {

	@Test
	void test() {
		long time = DateUtils.parse("1D 1H 1m 33s");
		long expected = 25*60*60000 + 60000 + 33000;
		
		System.err.println("time is: " + time);
		System.err.println("expected: " + expected);
		assertTrue(expected == time);
		assertEquals(expected, time);
		long now = System.currentTimeMillis();
		System.err.println(new Date(now + time));
	}

}
