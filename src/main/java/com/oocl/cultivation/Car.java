package com.oocl.cultivation;

import java.util.Objects;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 3:58 PM
 * @Version 1.0
 */
public class Car {
    private int carId;

    public int getCarId() {
        return carId;
    }

    public Car(int carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId);
    }
}
