package com.example.SpringTest;

import com.example.SpringTest.domain.Bucket;
import com.example.SpringTest.domain.Cars;
import com.example.SpringTest.repos.BucketRepos;
import com.example.SpringTest.repos.CarsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class RentCarController {

    @Autowired
    private CarsRepos carsRepos;
    Iterable<Cars> cars;

    @Autowired
    private BucketRepos bucketRepos;
    List<Bucket> bucket;

    @RequestMapping(value = "/rent-auto", method = RequestMethod.GET)
    public String RentCar(Map<String, Object> model) {
        cars = carsRepos.findAll();
        model.put("cars", cars);

        bucket = (List<Bucket>) bucketRepos.findAll();
        model.put("bucket", bucket.size());
        return "/RentCar";
    }

    @RequestMapping(value = "/rent-auto", method = RequestMethod.POST)
    @ResponseBody
    public String add_auto(@RequestParam String name, Map<String, Object> model){
        Bucket b = new Bucket(name);
        bucketRepos.save(b);

        bucket = (List<Bucket>) bucketRepos.findAll();
        model.put("bucket", bucket.size());
        return "{}";
    }

}