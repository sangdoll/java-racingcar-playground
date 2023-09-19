package racingcar.domain;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        isValidName(name);
        this.name = name;
    }

    private void isValidName(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 차량 이름은 5글자까지만 허용됩니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 차량 이름을 입력해주세요.");
        }
    }

    public String getName() {
        return name;
    }
}
