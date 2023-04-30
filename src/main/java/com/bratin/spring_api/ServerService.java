package com.bratin.spring_api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public List<Server> allServers() {
        return serverRepository.findAll();
    }

    public Optional<Server> oneServer(String id) {
        return serverRepository.findById(id);
    }

    public Server addServer(Server server) {
        return serverRepository.save(server);
    }

    public boolean deleteServer(String id) {
        try {
            serverRepository.deleteById(id);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public List<Server> findServer(String name) {
        return serverRepository.findServersByNameContaining(name);
    }
}
