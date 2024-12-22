package dika.springcars;

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
    public String car( @RequestParam(required = false) Integer count, @RequestParam(required = false) String sortBy, Model model) {
        List<Car> listCar = carService.listCars();
        List<String> disabledFields = sortConfig.getDisabledFields();
        if (count == null || count >= maxCar) {
            count = listCar.size();
        }

        if (disabledFields != null){
            if ((disabledFields.contains("model") && sortBy.compareTo("model") == 0)||
                    (disabledFields.contains("color") && sortBy.compareTo("color") == 0)||
                    (disabledFields.contains("maxSpeed") && sortBy.compareTo("maxSpeed") == 0)){
                sortBy = null;
            }
        }
        if (sortBy != null){
            if (sortBy.compareTo("model") == 0){
                listCar.sort((o1, o2) -> o1.getModel().compareTo(o2.getModel()));
            } else if (sortBy.compareTo("color") == 0){
                listCar.sort((o1, o2) -> o1.getColor().compareTo(o2.getColor()));
            } else if (sortBy.compareTo("maxSpeed") == 0){
                listCar.sort((o1, o2) -> o1.getMaxSpeed() - o2.getMaxSpeed());
            }
        }

        model.addAttribute("listCar", listCar.subList(0, count));
        return "index";
    }


}
