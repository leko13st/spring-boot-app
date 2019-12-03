package com.example.SpringTest.repos;

import com.example.SpringTest.domain.Cars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepos extends CrudRepository<Cars, Integer> {
}
