package baseball.controller;

import baseball.domain.Game;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

/**
 * 야구 게임을 진행하는 컨트롤러
 */
public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    /**
     * 생성자
     */
    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    /**
     * 게임을 실행한다.
     */
    public void run() {
        outputView.printStartMessage();
        boolean gameContinue = true;

        while (gameContinue) {
            Game game = new Game();
            boolean isCorrect = false;

            while (!isCorrect) {
                String userInput = inputView.getUserInput();
                List<Integer> userNumbers = convertInputToNumbers(userInput);
                if (userNumbers == null) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }

                int[] result = game.getResult(userNumbers);
                outputView.printResult(result[0], result[1]);

                if (result[0] == 3) {
                    outputView.printWinMessage();
                    isCorrect = true;
                }
            }

            int restartInput = inputView.getRestartInput();
            if (restartInput != 1) {
                gameContinue = false;
            }
        }
    }

    /**
     * 사용자의 입력값을 숫자 리스트로 변환한다.
     *
     * @param input 사용자의 입력값
     * @return 숫자 리스트
     */
    private List<Integer> convertInputToNumbers(String input) {
        if (input.length() != 3) {
            return null;
        }

        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            int number = Character.getNumericValue(ch);
            if (number < 1 || number > 9 || numbers.contains(number)) {
                return null;
            }
            numbers.add(number);
        }
        return numbers;
    }
}
