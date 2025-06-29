package com.udemy.spring.section03.exercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService {
    public int[] retrieveData() {
        return new int[]{11, 22, 33, 44, 55};
    }
}
