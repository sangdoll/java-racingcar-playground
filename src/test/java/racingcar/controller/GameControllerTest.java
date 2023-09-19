package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {
    GameController controller;
    OutputStream out;

    @BeforeEach
    void setUp() {
        controller = new GameController();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("게임을 정상적으로 시작하고, 마치는지 확인합니다.")
    @Test
    void playGame_WithValidInputs_GameCompletesSuccessfully() {
        Cars players = new Cars("pobi,james,lee");
        int round = 5;

        controller.playGame(players, round);
        // 최종 우승자를 출력하면, 게임이 정상적으로 진행되었다고 할 수 있음.
        assertThat(out.toString()).contains("pobi", "james", "lee", "최종 우승", "-");
    }
}