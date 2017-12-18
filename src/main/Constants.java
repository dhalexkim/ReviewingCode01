package main;

import java.time.format.DateTimeFormatter;

public final class Constants {

	// Constants
	public static final String TIME_FORMAT = "HH:mm";
	public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
}
