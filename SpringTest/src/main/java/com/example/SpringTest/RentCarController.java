package com.example.SpringTest;

import com.example.SpringTest.domain.Bucket;
import com.example.SpringTest.domain.Cars;
import com.example.SpringTest.repos.BucketRepos;
import com.example.SpringTest.repos.CarsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class RentCarController {

    public static final String LIST_CARS_NAME = "list_cars_name";
    @Autowired
    private CarsRepos carsRepos;
    Iterable<Cars> cars;

    @Autowired
    private BucketRepos bucketRepos;
    List<Bucket> bucket;

    static final String id_session = "id_session";


    @GetMapping("/rent-auto")
    public String RentCar(Map<String, Object> model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute(id_session);
        if (value == null)
            value = "!";
        session.setAttribute(id_session, (value + "1"));

        cars = carsRepos.findAll();
        model.put("cars", cars);

        bucket = (List<Bucket>) bucketRepos.findAll();
        model.put("bucket", bucket.size());
        return "/RentCar";
    }

    @PostMapping("/rent-auto")
    @ResponseBody
    public String add_auto(@RequestParam String name, Map<String, Object> model, HttpServletRequest request) {


        HttpSession session = request.getSession();
        ArrayList<String> list_cars_name = (ArrayList<String>) session.getAttribute(LIST_CARS_NAME);
        if (list_cars_name == null) list_cars_name = new ArrayList<>();
        list_cars_name.add(name);
        session.setAttribute(LIST_CARS_NAME, list_cars_name);

        /*Bucket b = new Bucket(name);
        bucketRepos.save(b);*/

        model.put("bucket", list_cars_name.size());
        return "{}";
    }

    @GetMapping("/bucket")
    public String bucket(Map<String, Object> model){
        var cars = (List<Bucket>) bucketRepos.findAll();
        model.put("cars", cars);
        return "Bucket";
    }

    @GetMapping("/get-cart-count")
    @ResponseBody
    public String getCartCount(HttpServletRequest request) {

        HttpSession session = request.getSession();
        ArrayList<String> list_cars = (ArrayList<String>) session.getAttribute("list_cars");

        return "{count:"+list_cars.size()+"}";
    }

}