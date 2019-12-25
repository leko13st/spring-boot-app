package com.example.SpringTest;

import com.example.SpringTest.domain.Car_db;
import com.example.SpringTest.domain.Cars;
import com.example.SpringTest.repos.Car_dbRepos;
import com.example.SpringTest.repos.CarsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private Car_dbRepos car_dbRepos;

    private static final String LIST_CARS = "list_cars";

    @GetMapping("/rent-auto")
    public String RentCar(Map<String, Object> model) {

        cars = carsRepos.findAll();
        model.put("cars", cars);

        return "rent-car";
    }

    @PostMapping("/rent-auto")
    @ResponseBody
    public String add_auto(@RequestParam String name, @RequestParam int price, Map<String, Object> model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        ArrayList<Cars> list_cars = (ArrayList<Cars>) session.getAttribute(LIST_CARS);
        if (list_cars == null)
            list_cars = new ArrayList<>();

        Cars car = new Cars(name, price);
        list_cars.add(car);

        session.setAttribute(LIST_CARS, list_cars);
        model.put("cart", list_cars.size());

        return "{}";
    }

    @GetMapping("/passive-button-index")
    @ResponseBody
    public String getPassiveButtonName(HttpServletRequest request){
        HttpSession session = request.getSession();
        ArrayList<Cars> cars = (ArrayList<Cars>) session.getAttribute(LIST_CARS);
        String answer = "";
        for (int i = 0; i < cars.size(); i++) {
            if (i != 0) answer += ", ";
            answer += "\"" + cars.get(i).getName() + "\"";
        }
        return "{\"indexes\":[" + answer + "]}";
    }

    @GetMapping("/cart")
    public String bucket(Map<String, Object> model, HttpServletRequest request){
        HttpSession session = request.getSession();
        ArrayList<Cars> list_cars = (ArrayList<Cars>) session.getAttribute(LIST_CARS);
        model.put("cars", list_cars);

        return "cart";
    }

    @GetMapping("/get-cart-count")
    @ResponseBody
    public String getCartCount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ArrayList<Cars> list_cars = (ArrayList<Cars>) session.getAttribute(LIST_CARS);

        return "{\"count\":\"" +list_cars.size()+ "\"}";
    }

    @PostMapping("/delete-cart-auto")
    @ResponseBody
    public String deleteCartAuto(@RequestParam int id, Map<String, Object> model, HttpServletRequest request){
        HttpSession session = request.getSession();
        ArrayList<Cars> list_cars = (ArrayList<Cars>) session.getAttribute(LIST_CARS);
        list_cars.remove(id);
        session.setAttribute(LIST_CARS, list_cars);

        return "{}";
    }

    @PostMapping("/cart/add-to-db")
    public String addToDb(HttpServletRequest request){
        HttpSession session = request.getSession();
        ArrayList<Cars> list_cars = (ArrayList<Cars>) session.getAttribute(LIST_CARS);

        for (Cars s : list_cars) {
            Car_db carDb = new Car_db(s.getName());
            car_dbRepos.save(carDb);
        }

        list_cars.clear();
        session.setAttribute(LIST_CARS, list_cars);

        return "redirect:../cart";
    }

    @GetMapping(value = "/get-cars", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> GetCars(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        ArrayList<Cars> cars_list = (ArrayList<Cars>) carsRepos.findAll();

        String answer = "";
        for (int i = 0; i < cars_list.size(); i++) {
            if (i != 0) answer += ",";
            answer += "{\"id\":\"" + cars_list.get(i).getId() + "\", \"name\":\"" + cars_list.get(i).getName() + "\", \"price\":\"" + cars_list.get(i).getPrice() + "\"}";
        }
        return new ResponseEntity<>("{\"cars\":[" + answer + "]}", responseHeaders, HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @PostMapping("/buy-cars")
    public String addToDbfromReact(@RequestParam String srcData){

        String ans = null;
        /*for (String s : cars_list) {
            Car_db carDb = new Car_db(s);
            car_dbRepos.save(carDb);
        }*/

        return "";
    }
}