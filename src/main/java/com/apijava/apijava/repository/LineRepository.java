package com.apijava.apijava.repository;

import com.apijava.apijava.model.Line;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LineRepository extends MongoRepository<Line, Integer> {

    @Query(value = "{ 'nome': { $regex: ?0, $options: 'i' } }")
    List<Line> findByName(String nome);

}
