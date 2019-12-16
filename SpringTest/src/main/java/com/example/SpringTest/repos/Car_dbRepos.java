package com.example.SpringTest.repos;

import com.example.SpringTest.domain.Car_db;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Car_dbRepos extends CrudRepository<Car_db, Integer> {
}
