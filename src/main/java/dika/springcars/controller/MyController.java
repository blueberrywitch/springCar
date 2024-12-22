package dika.springcars.controller;

import dika.springcars.config.SortConfig;
import dika.springcars.model.Car;
import dika.springcars.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    CarServiceImpl carService;

    @Autowired
    SortConfig sortConfig;

    @Value("${custom.maxCar}")
    private int maxCar;

    @GetMapping("/cars")
    public String car(@RequestParam(required = false) Integer count, @RequestParam(required = false) String sortBy, Model model) {
        List<String> headers = List.of("ID", "Model", "Max Speed", "Color");
        List<Car> listCar = carService.listCars();
        List<String> disabledFields = sortConfig.getDisabledFields();
        if (count == null || count >= maxCar) {
            count = listCar.size();
        }

        if (sortBy != null) {
            if (disabledFields != null) {
                if ((disabledFields.contains("model") && sortBy.compareTo("model") == 0) ||
                        (disabledFields.contains("color") && sortBy.compareTo("color") == 0) ||
                        (disabledFields.contains("maxSpeed") && sortBy.compareTo("maxSpeed") == 0)) {
                    sortBy = null;
                } else {
                    switch (sortBy) {
                        case "model" -> listCar.sort((o1, o2) -> o1.getModel().compareTo(o2.getModel()));
                        case "color" -> listCar.sort((o1, o2) -> o1.getColor().toString().compareTo(o2.getColor().toString()));
                        case "maxSpeed" -> listCar.sort((o1, o2) -> o1.getMaxSpeed() - o2.getMaxSpeed());

                    }
                }
            }
        }

        model.addAttribute("listheaders", headers);
        model.addAttribute("listCar", listCar.subList(0, count));
        return "index";
    }


}
