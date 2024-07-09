package com.example.restjpa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MessageErrors {

    private List<Violation> violations;

    @Data
    @AllArgsConstructor
    public static class Violation{

        public String fieldName;
        public String message;

    }
}
