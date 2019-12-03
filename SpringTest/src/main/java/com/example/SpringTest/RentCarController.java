package com.example.SpringTest;

import com.example.SpringTest.domain.Bucket;
import com.example.SpringTest.domain.Cars;
import com.example.SpringTest.repos.BucketRepos;
import com.example.SpringTest.repos.CarsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class RentCarController {

    private Integer itemCount = 0;
    @Autowired
    private CarsRepos carsRepos;
    Iterable<Cars> cars;

    @Autowired
    private BucketRepos bucketRepos;
    List<Bucket> bucket;

    @GetMapping("/rent-auto")
    public String RentCar(Map<String, Object> model) {
        cars = carsRepos.findAll();
        model.put("cars", cars);

        bucket = (List<Bucket>) bucketRepos.findAll();
        model.put("bucket", bucket.size());
        return "RentCar";
    }/*

    @PostMapping("/rent-auto")
    public String add_auto(@RequestParam String auto){
        Bucket b = new Bucket(auto);
        bucketRepos.save(b);

        return "RentCar";
    }*/
}