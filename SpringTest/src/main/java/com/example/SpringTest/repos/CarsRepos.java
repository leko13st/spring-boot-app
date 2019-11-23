package com.example.SpringTest.repos;

import com.example.SpringTest.domain.Cars;
import org.springframework.data.repository.CrudRepository;

public interface CarsRepos extends CrudRepository<Cars, Integer> {
}
