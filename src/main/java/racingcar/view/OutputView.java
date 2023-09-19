package racingcar.view;

public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printOneLine() {
        System.out.println();
    }

    public void printResult(String name, String location) {
        System.out.printf("%s : %s\n", name, location);
    }

    public void printWinners(String winners) {
        System.out.printf("%s가 최종 우승했습니다.\n", winners);
    }
}
