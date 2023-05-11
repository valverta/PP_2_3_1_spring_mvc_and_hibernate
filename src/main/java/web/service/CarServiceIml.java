package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceIml implements CarService{
    private final List<Car> cars = new ArrayList<>(Arrays.asList(new Car(3, "BMW e92_m", "Gray"),
            new Car(5, "BMW f90_m", "Black"),
            new Car(3, "Subaru Impreza WRX STI", "Space gray"),
            new Car(992, "Porsche 911 Carrera 4S", "Dark green"),
            new Car(1, "Tesla Model S Plaid", "Black")));

    @Override
    public List<Car> carsCount(Integer count) {
        return (count == null || count < 0 || count > cars.size()) ? cars : cars.subList(0, count);
    }
}
