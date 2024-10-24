package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private final List<Car> carList = new ArrayList<>();
    private int maxScore = 0;

    public CarGroup(String[] carList) {
        for (String carName : carList) {
            Car car = new Car(carName);
            this.carList.add(car);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void go() {
        for (Car car : carList) {
            car.drive();
        }
    }

    public int getMaxScore() {
        for (Car car : carList) {
            int i = car.getScore();
            if (maxScore < i) {
                maxScore = i;
            }
        }
        return maxScore;
    }
}