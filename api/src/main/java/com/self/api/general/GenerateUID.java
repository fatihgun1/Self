package com.self.api.general;

import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class GenerateUID {
    public static String generateCode(){
        String uuid = UUID.randomUUID().toString();
        return uuid.split("-")[4];
    }

}
