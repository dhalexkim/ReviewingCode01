package main.stp01.model;

import java.time.LocalTime;

import main.Constants;

public class Event {

	// Properties
	private String eventName;
	private LocalTime startTime;
	private LocalTime endTime;
	
	// Constructors
	public Event() {
		this.setEventName("");
		this.setStartTime(LocalTime.MIN.format(Constants.timeFormatter));
		this.setEndTime(LocalTime.MIN.format(Constants.timeFormatter));
	}
	
	public Event(String eventName, String startTime, String endTime) {
		this.setEventName(eventName);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
	}
	
	// Methods
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public void setStartTime(String bookTime) {
		this.startTime = LocalTime.parse(bookTime);
	}
	
	public void setEndTime(String bookTime) {
		this.endTime = LocalTime.parse(bookTime);
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public String getStartTime() {
		return startTime.format(Constants.timeFormatter);
	}
	
	public String getEndTime() {
		return endTime.format(Constants.timeFormatter);
	}
}
