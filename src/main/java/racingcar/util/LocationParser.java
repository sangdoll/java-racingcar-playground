package racingcar.util;

public class LocationParser {
    public String parsing(int location) {
        return "-".repeat(Math.max(0, location));
    }
}
