package com.example.SpringTest;

import com.example.SpringTest.domain.Cars;
import com.example.SpringTest.repos.CarsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RentCarController {
    /*
    private String carName;
    private String EngineType;
    private String Power;
    private int Price;

    @GetMapping("/rentAuto")
    public String auto(Model model) {
        model.addAttribute("carName", carName);
        model.addAttribute("EngineType", EngineType);
        model.addAttribute("Power", Power);
        model.addAttribute("Price", Price);
        return "RentCar";
    }

    @GetMapping("/rent-auto")
    public String rentAuto(
            @RequestParam(name="name", required=false, defaultValue="") String name, Model model) {
        if (name.equals("ferrari")){
            addAtr(model, 0);
        }
        else if (name.equals("gelik")){
            addAtr(model, 1);
        }
        else if (name.equals("porsche")){
            addAtr(model, 2);
        }
        return "Applying";
    }

    public void addAtr(Model model, int i){
        model.addAttribute("carName", );
        model.addAttribute("EngineType", EngineType[i]);
        model.addAttribute("Power", Power[i]);
        model.addAttribute("Price", Price[i]);
    }
     */

    @Autowired
    private CarsRepos carsRepos;
    Iterable<Cars> cars;

    @GetMapping("/rent-auto")
    public String RentCar(Map<String, Object> model) {
        cars = carsRepos.findAll();
        model.put("cars", cars);
        return "RentCar";
    }
}