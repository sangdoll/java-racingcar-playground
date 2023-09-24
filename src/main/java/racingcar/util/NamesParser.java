package racingcar.util;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamesParser {
    private final String names;

    public NamesParser(String names) {
        if (!names.matches("([\\w]+,?)+")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
        }
        this.names = names;
    }

    public List<Car> parsing() {
        return Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
