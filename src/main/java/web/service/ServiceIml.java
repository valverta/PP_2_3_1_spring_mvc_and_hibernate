package web.service;

import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceIml implements Service{
    @Override
    public List<Car> carsCount(List<Car> cars, int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
