package com.example.sss;

//여긴 다시 공부해야함//

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;
        public DataNotFoundException(String message){
            super(message);
        }
    }

