package com.perfumar.perfumar_proyect.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Perfume {
    private final UUID id;
    private final String name;

    //contructor
    public Perfume(@JsonProperty("id") UUID id, @JsonProperty String name){
        this.id = id;
        this.name = name;
    }

    //definir getters and setters
    public UUID getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
