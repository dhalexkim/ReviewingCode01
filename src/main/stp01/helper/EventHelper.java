package main.stp01.helper;

import java.util.ArrayList;
import java.util.List;

import main.stp01.model.Event;

public class EventHelper {
		
	// Constructor
	public EventHelper() {
		
	}
	
	// Methods
	
	/**
	 * Create a event with necessary properties.
	 * @param eventName The event name
	 * @param startTime The event start time in 24-hour military time
	 * @param endTime The event end time in 24-hour military time
	 * @return Event with provided property values.
	 */
	public Event createEvent(String eventName, String startTime, String endTime) {
		return new Event(eventName, startTime, endTime);
	}
	
	/**
	 * Create following events with provided informations: <br/> <p>
	 *    [(Name: EventName01), (StartTime: 10:00), (EndTime: 11:30)] <br/>
	 *    [(Name: EventName02), (StartTime: 11:00), (EndTime: 12:00)] <br/>
	 *    [(Name: EventName03), (StartTime: 12:00), (EndTime: 15:00)] <br/>
	 *    [(Name: EventName04), (StartTime: 13:00), (EndTime: 17:00)] <br/>
	 *    [(Name: EventName05), (StartTime: 09:40), (EndTime: 12:40)] <br/>
	 *    [(Name: EventName06), (StartTime: 05:00), (EndTime: 20:30)] <br/>
	 *    [(Name: EventName07), (StartTime: 14:10), (EndTime: 14:30)] <br/>
	 * @return The events with provided property values.
	 */
	public List<Event> createEvents() {
		
		List<Event> eventList = new ArrayList<Event>();
		
		eventList.add(createEvent("EventName01", "10:00", "11:30"));
		eventList.add(createEvent("EventName02", "11:00", "12:00"));
		eventList.add(createEvent("EventName03", "12:00", "15:00"));
		eventList.add(createEvent("EventName04", "13:00", "17:00"));
		eventList.add(createEvent("EventName05", "09:40", "12:40"));
		eventList.add(createEvent("EventName06", "05:00", "20:30"));
		eventList.add(createEvent("EventName07", "14:10", "14:30"));
				
		return eventList;
	}
	
	/**
	 * Find conflicting event(s) with the target event from the provided events.
	 * @param targetEvent The target event
	 * @param events The available events
	 * @param excludeTargetEvent The boolean parameter if target event should be removed from result.
	 *  If this set to false, the result will contain target event as well if target event exists in provided events.
	 * @return Conflicting event(s) with the target event from the provided events.
	 */
	public List<Event> findConflictingEvents(Event targetEvent, List<Event> events, boolean excludeTargetEvent) {
		List<Event> conflictingEvents = new ArrayList<Event>();
		
		for (Event event : events) {
			if ( event.getEndTime().compareTo(targetEvent.getStartTime()) > 0 && event.getStartTime().compareTo(targetEvent.getEndTime()) < 0) {
				conflictingEvents.add(event);
			}
		}
		
		if (excludeTargetEvent) {
			int targetIndex = conflictingEvents.indexOf(targetEvent);
			if (targetIndex > 0) {
				conflictingEvents.remove(targetIndex);
			}
	
		}
		
		return conflictingEvents;
	}
	
	/**
	 * Print a event in readable format.
	 * @param event The event to print
	 */
	public void printEvent(Event event) {
		System.out.println("[(Name: " + event.getEventName() + 
				"), (StartTime: " + event.getStartTime() +
				"), (EndTime: " + event.getEndTime() + ")]");
	}
	
	/**
	 * Print events in readable format.
	 * @param events The events to print
	 */
	public void printEvents(List<Event> events) {
		System.out.println("{");
		for(Event event : events) {
			printEvent(event);
		}
		System.out.println("}");
	}
	
}
