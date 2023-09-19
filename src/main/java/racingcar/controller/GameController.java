package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Map;
import java.util.Set;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startGame() {
        Cars players = new Cars(inputView.getPlayersName());
        int round = inputView.getTotalRound();
        playGame(players, round);
    }

    public void playGame(Cars players, int round) {

        outputView.printMessage("\n실행 결과");
        for (int i = 0; i < round; i++) {
            players.moveAllCars();
            Set<Map.Entry<String, String>> result = players.getRoundResult();
            result.forEach(e -> outputView.printResult(e.getKey(), e.getValue()));
            outputView.printOneLine();
        }

        outputView.printWinners(players.getWinningCarNames());
    }
}
