package racingcar.util;

public class LocationParser {
	private static final String DASH = "-";
	public static String parsing(int location) {
		return DASH.repeat(Math.max(0, location));
	}
}
