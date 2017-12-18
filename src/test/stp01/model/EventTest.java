package test.stp01.model;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.Constants;
import main.stp01.model.Event;


class EventTest {
	
	@Test
	public void testEventConstructor_ConstructorWithoutParameters_VerfiyEvent() {
		
		// Arrange
		Event event = new Event();
		
		// Assert
		Assert.assertNotNull("event object should not be null!", event);
		Assert.assertEquals(0, event.getEventName().length());
		Assert.assertEquals(LocalTime.MIN.format(Constants.timeFormatter), event.getStartTime());
		Assert.assertEquals(LocalTime.MIN.format(Constants.timeFormatter), event.getEndTime());
	}
	
	@Test
	public void testEventConstructor_ConstuctorWithParameters_VerifyEvent() {
		// Arrange
		String eventName = "EventName";
		String eventStartTime = LocalTime.NOON.format(Constants.timeFormatter);
		String eventEndTime = LocalTime.MAX.format(Constants.timeFormatter);
		Event event = new Event(eventName, eventStartTime, eventEndTime);
		
		// Assert
		Assert.assertNotNull("event object should not be null!", event);
		Assert.assertEquals(eventName, event.getEventName());
		Assert.assertEquals(eventStartTime, event.getStartTime());
		Assert.assertEquals(eventEndTime, event.getEndTime());
	}

	@Test
	public void testSetStartTime_SetValidStartTime_VerifyStartTime() {
		
		// Arrange
		String startTime = LocalTime.now().format(Constants.timeFormatter);
		Event event = new Event();
		event.setStartTime(startTime);
		
		// Assert
		Assert.assertEquals("event startTime value should be same as the one set from setStartTime.",
				startTime, event.getStartTime());
	}
	
	@Test
	public void testSetEndTime_SetValidEndTime_VerifyEndTime() {
		
		// Arrange
		String endTime = LocalTime.now().format(Constants.timeFormatter);
		Event event = new Event();
		event.setEndTime(endTime);
		
		// Assert
		Assert.assertEquals("event endTime value should be same as the one set from setEndTime.",
				endTime, event.getEndTime());

	}
	
	@Test
	public void testSetStartTime_SetInValidStartTime_VerifyDateTimeParseException() {
		
		// Arrange
		String InvalidStartTime = "Invalid";
		Event event = new Event();
		
		// Expected error
		try {
			event.setStartTime(InvalidStartTime);
		} catch (DateTimeParseException ex) {
			Assert.assertNotNull(ex.getMessage());
		}
	}
	
	@Test
	public void testSetEndTime_SetInValidEndTime_VerifyDateTimeParseException() {
		
		// Arrange
		String InvalidEndTime = "Invalid";
		Event event = new Event();
		
		// Expected error
		try {
			event.setEndTime(InvalidEndTime);
		} catch (DateTimeParseException ex) {
			Assert.assertNotNull(ex.getMessage());
		}
	}
}
