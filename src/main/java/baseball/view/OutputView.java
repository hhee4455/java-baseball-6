package baseball.view;

public class OutputView {
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            String result = "";
            if (ball > 0) {
                result += ball + "볼 ";
            }
            if (strike > 0) {
                result += strike + "스트라이크";
            }
            System.out.println(result.trim());
        }
    }

    public void printWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}