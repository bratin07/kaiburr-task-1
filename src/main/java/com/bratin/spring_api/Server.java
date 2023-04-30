package com.bratin.spring_api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "server")
public class Server {

    private String name;
    private String id;
    private String language;
    private String framework;
}