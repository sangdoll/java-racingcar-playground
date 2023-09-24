package racingcar.view;


public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWinner(String winners) {
        System.out.println(winners + "가 최종 우승하였습니다.");
    }

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }
}
