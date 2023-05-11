package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarsController {
    @Autowired
    private CarService service;

    @GetMapping(value = "/cars")
    public String car(@RequestParam(value = "count", required = false) Integer count, Model model) {
        model.addAttribute("cars", service.carsCount(count));
        return "cars";
    }
}
