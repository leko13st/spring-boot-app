package com.example.SpringTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentCarController {
    private String[] carName = { "Ferrari 488 GTB", "Mercedes Gelandewagen G-Class", "Porsche 911 Carrera S"};
    private String[] EngineType = { "V8", "V8", "V6"};
    private String[] Power = { "670 л.с.", "422 л.с.", "422 л.с."};
    private int[] Price = { 50000, 20000, 25000};

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
        model.addAttribute("carName", carName[i]);
        model.addAttribute("EngineType", EngineType[i]);
        model.addAttribute("Power", Power[i]);
        model.addAttribute("Price", Price[i]);
    }
}