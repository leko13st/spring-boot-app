package com.example.SpringTest.repos;

import com.example.SpringTest.domain.Bucket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepos extends CrudRepository<Bucket, Integer> {
}