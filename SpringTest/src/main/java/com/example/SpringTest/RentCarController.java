package com.example.SpringTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentCarController {
    private String name;

    @GetMapping("/rentAuto")
    public String auto() {
        return "RentCar";
    }

    @GetMapping("/rent-auto")
    public String rentAuto(
            @RequestParam(name="name", required=false, defaultValue="") String name, Model model) {
        model.addAttribute("name", name);
        return "Applying";
    }
}