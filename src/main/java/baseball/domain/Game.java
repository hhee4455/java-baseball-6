package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> computerNumbers;

    /**
     * 생성자
     */
    public Game() {
        generateComputerNumbers();
    }

    /**
     * 컴퓨터의 숫자를 생성한다.
     */
    private void generateComputerNumbers() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    /**
     * 사용자의 입력값과 컴퓨터의 숫자를 비교하여 결과를 반환한다.
     *
     * @param userNumbers 사용자의 입력값
     * @return 결과
     */
    public int[] getResult(List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                ball++;
            }
        }

        return new int[]{strike, ball};
    }
}
