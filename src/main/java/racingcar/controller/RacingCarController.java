package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private final RacingCarView view = new RacingCarView();
    private CarGroup carGroup;
    private int tryNum;

    public void startRace() {
        // 자동차 이름 입력
        view.getCarInputString();
        String carInputString = Console.readLine();
        carGroup = new CarGroup(carInputString.split(","));

        // 시도 횟수 입력
        view.getTryInputString();
        String tryInputString = Console.readLine();
        checkTryNumLength(tryInputString);
        tryNum = Integer.parseInt(tryInputString);

        // race
        race(carGroup, tryNum);

        // 결과
        carGroup.getMaxScore();
        view.getOutputString(getWinnerString(carGroup));
    }

    private void checkTryNumLength(String tryNum) {
        if (tryNum.length() == 0) {
            throw new IllegalArgumentException("시도 횟수가 입력되지 않았습니다.");
        }
    }

    private void race(CarGroup carGroup, int tryNum) {
        for (int i = 0; i < tryNum; i++) {
            carGroup.go();
            printNow(carGroup);
        }
    }

    private void printNow(CarGroup carGroup) {
        for (Car car : carGroup.getCarList()) {
            System.out.println(car.getName() + " : " + car.scoreToDash(car.getScore()));
        }
        System.out.println();
    }

    private String getWinnerString(CarGroup carGroup) {
        return Arrays.toString(carGroup.getWinnerCarList().toArray())
                .replace("[", "").replace("]", "");
    }
}
