package com.example.SpringTest;

import com.example.SpringTest.domain.Cars;
import com.example.SpringTest.repos.CarsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class RentCarController {

    @Autowired
    private CarsRepos carsRepos;
    Iterable<Cars> cars;

    private static final String LIST_CARS_NAME = "list_cars_name";

    @GetMapping("/rent-auto")
    public String RentCar(Map<String, Object> model) {

        cars = carsRepos.findAll();
        model.put("cars", cars);

        return "rent-car";
    }

    @PostMapping("/rent-auto")
    @ResponseBody
    public String add_auto(@RequestParam String name, Map<String, Object> model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        ArrayList<String> list_cars_name = (ArrayList<String>) session.getAttribute(LIST_CARS_NAME);
        if (list_cars_name == null) list_cars_name = new ArrayList<>();
        list_cars_name.add(name);

        session.setAttribute(LIST_CARS_NAME, list_cars_name);
        model.put("cart", list_cars_name.size());
        return "{}";
    }

    @GetMapping("/cart")
    public String bucket(Map<String, Object> model, HttpServletRequest request){
        HttpSession session = request.getSession();
        ArrayList<String> list_cars_name = (ArrayList<String>) session.getAttribute(LIST_CARS_NAME);
        model.put("cars", list_cars_name);

        return "cart";
    }

    @GetMapping("/get-cart-count")
    @ResponseBody
    public String getCartCount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ArrayList<String> list_cars_name = (ArrayList<String>) session.getAttribute(LIST_CARS_NAME);

        return "{\"count\":\"" +list_cars_name.size()+ "\"}";
    }

    @PostMapping("delete-cart-auto")
    @ResponseBody
    public String deleteCartAuto(@RequestParam int id, Map<String, Object> model, HttpServletRequest request){
        HttpSession session = request.getSession();
        ArrayList<String> list_cars_name = (ArrayList<String>) session.getAttribute(LIST_CARS_NAME);
        list_cars_name.remove(id);
        session.setAttribute(LIST_CARS_NAME, list_cars_name);
        return "{}";
    }
}