package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.util.RandomNumbersList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final RandomNumbersList randomNumbersList = new RandomNumbersList();

	public void game() {
		String carNames = inputView.getCarsName();
		Cars cars = Cars.from(carNames);
		int round = inputView.getTotalRound();

		play(cars, round);
	}

	private void play(Cars cars, int round) {
		outputView.printResultMessage();
		// 각 라운드마다 차를 랜덤 숫자를 이용하여 전진시킨 뒤, 결과를 출력함
		for (int i = 0; i < round; i++) {
			cars.moveAllCars(randomNumbersList.getRandomNumbers(cars.getCarsCount()));
			outputView.printMessage(cars.getPrintResult());
		}
		outputView.printWinner(cars.getMaxLocationCarsName());
	}
}
