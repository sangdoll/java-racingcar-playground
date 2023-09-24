package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.util.RandomNumbers;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomNumbers randomNumbers = new RandomNumbers();

    public void playGame() {
        String carNames = inputView.getCarsName();
        Cars cars = new Cars(carNames);

        int totalRounds = inputView.getTotalRound();

        outputView.printResultMessage();
        // 각 라운드마다 차를 랜덤 숫자를 이용하여 전진시킨 뒤, 결과를 출력함
        for (int i = 0; i < totalRounds; i++) {
            cars.moveAllCars(randomNumbers.getRandomNumbers(cars.getTotalCount()));
            outputView.printMessage(cars.getResult());
        }
        outputView.printWinner(cars.getMaxLocationCarsName());
    }
}
