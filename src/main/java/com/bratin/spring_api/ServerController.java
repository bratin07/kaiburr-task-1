package com.bratin.spring_api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerController {
    
    @Autowired
    private ServerService serverService;

    @GetMapping
    public List<Server> getAllServers() {
        return serverService.allServers();
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneServer(@PathVariable String id) {
        Optional<Server> server = serverService.oneServer(id);
        if(server.isPresent()) {
            return new ResponseEntity(server, HttpStatus.OK);
        } else {
        return new ResponseEntity("Server Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public Server addServer(@RequestBody Server server) {
        return serverService.addServer(server);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteServer(@PathVariable String id) {
        if(serverService.deleteServer(id)) {
            return new ResponseEntity<String>("Server deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Server id not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find")
    public ResponseEntity findServer(@RequestParam String name) {
        List<Server> servers = serverService.findServer(name);
        if(servers.isEmpty()) {
            return new ResponseEntity("Server Not Found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(servers, HttpStatus.OK);
        }
    }
}
