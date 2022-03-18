package com.example.permits_ultimate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIO {
    private ObjectMapper objectMapper;

    public JsonIO() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public void serializeToJson(List<Player> playerList, File source){
        try {
            objectMapper.writeValue(source, playerList);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public List<Player> deserializeFromJson(File source){
        List<Player> players = new ArrayList<>();
        try{
            players = objectMapper.readValue(source, new TypeReference<List<Player>>(){});
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return players;
    }
}
