package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.Service;
import web.service.ServiceIml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/cars")
	public String car(@RequestParam(value = "count", required = false) String count, Model model) {
		Service service = new ServiceIml();
		List<Car> cars = new ArrayList<>(Arrays.asList(new Car(3, "BMW e92_m", "Gray"),
				new Car(5, "BMW f90_m", "Black"),
				new Car(3, "Subaru Impreza WRX STI", "Space gray"),
				new Car(992, "Porsche 911 Carrera 4S", "Dark green"),
				new Car(1, "Tesla Model S Plaid", "Black")));
		try {
			model.addAttribute("cars", service.carsCount(cars, Integer.parseInt(count)));
		} catch (Exception e) {
			model.addAttribute("cars", cars);
		}
		return "cars";
	}
}