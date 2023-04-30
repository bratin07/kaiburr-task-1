package com.bratin.spring_api;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerRepository extends MongoRepository<Server, String> {
    public List<Server> findServersByNameContaining(String name);
}
