/**
* The Program implements finding overlapping event(s) from perspective of each target event.
*
* @author  Alex Kim
* @version 1.0
* @since   2017-12-16 
*/

package main;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.stp01.helper.EventHelper;
import main.stp01.model.Event;

public class Program {

	private static Logger logger = LogManager.getLogger(Program.class);

	public static void main(String[] args) {

		logger.info("Creating Event List.");

		EventHelper eventHelper = new EventHelper();

		List<Event> events = eventHelper.createEvents();

		eventHelper.printEvents(events);

		logger.info("Finding Overlapping Event(s) for Each Available Target Event.");

		for (Event targetEvent : events) {

			logger.info("Event(s) conflicts with the target event: ");
			logger.info("Event Name: " + targetEvent.getEventName());
			logger.info("Start Time: " + targetEvent.getStartTime());
			logger.info("End   Time: " + targetEvent.getEndTime());

			List<Event> conflictingEvents = eventHelper.findConflictingEvents(targetEvent, events, true);

			eventHelper.printEvents(conflictingEvents);
		}
	}
}
