package test.stp01.helper;

import java.time.LocalTime;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Constants;
import main.stp01.helper.EventHelper;
import main.stp01.model.Event;

class EventHelperTest {

	@Test
	void testEventHelperConstructor() {
		// Arrange
		EventHelper eventHelper = new EventHelper();
		
		// Assert
		Assert.assertNotNull(eventHelper);	
	}

	@Test
	void testCreateEvent_VerifyCreatedEvent() {
		// Arrange
		EventHelper eventHelper = new EventHelper();
		Event event = eventHelper.createEvent("EventName",
				LocalTime.MIN.format(Constants.timeFormatter),
				LocalTime.MIN.format(Constants.timeFormatter));
		
		// Assert
		Assert.assertNotNull(eventHelper);
		Assert.assertEquals("EventName", event.getEventName());
		Assert.assertEquals(LocalTime.MIN.format(Constants.timeFormatter), event.getStartTime());
		Assert.assertEquals(LocalTime.MIN.format(Constants.timeFormatter), event.getEndTime());	
	}

	@Test
	void testCreateEvents_VerifyCreatedEventListLength() {
		// Arrange
		EventHelper eventHelper = new EventHelper();
		List<Event> events = eventHelper.createEvents();
		
		// Assert
		Assert.assertEquals(7, events.size());
	}

	@ParameterizedTest
	@ValueSource(strings = { "true", "false" })
	void testFindConflictingEvents_UsingNonConflictingEvent_NoConflictingEvent(String excludeTargetEvent) {
		// Arrange
		EventHelper eventHelper = new EventHelper();
		Event targetEvent = eventHelper.createEvent("EventName",
				LocalTime.MIN.format(Constants.timeFormatter),
				LocalTime.MIN.format(Constants.timeFormatter));
		List<Event> events = eventHelper.createEvents();
		List<Event> conflictingEvents = eventHelper.findConflictingEvents(targetEvent, events,
				Boolean.parseBoolean(excludeTargetEvent));
		
		// Assert
		Assert.assertEquals(0, conflictingEvents.size());
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "true", "false" })
	void testFindConflictingEvents_UsingAllDayEvent_AllConflictingEvents(String excludeTargetEvent) {
		// Arrange
		EventHelper eventHelper = new EventHelper();
		Event targetEvent = eventHelper.createEvent("EventName",
				LocalTime.MIN.format(Constants.timeFormatter),
				LocalTime.MAX.format(Constants.timeFormatter));
		List<Event> events = eventHelper.createEvents();
		List<Event> conflictingEvents = eventHelper.findConflictingEvents(targetEvent, events,
				Boolean.parseBoolean(excludeTargetEvent));

		// Assert
		Assert.assertEquals(7, conflictingEvents.size());
	}

}
