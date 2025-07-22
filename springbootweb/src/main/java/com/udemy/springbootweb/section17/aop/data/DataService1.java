package com.udemy.springbootweb.section17.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retrieveData() {
        return new int[] {1,2,4,1,4,32,43,};
    }
}
