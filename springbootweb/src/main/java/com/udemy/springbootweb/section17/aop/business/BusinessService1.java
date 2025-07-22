package com.udemy.springbootweb.section17.aop.business;

import com.udemy.springbootweb.section17.aop.annotations.TrackTime;
import com.udemy.springbootweb.section17.aop.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private DataService1 dataService1;

    public BusinessService1(DataService1 d) {
        this.dataService1 = d;
    }

    public int getMax() {
        return Arrays.stream(dataService1.retrieveData()).max().orElse(0);
    }

    @TrackTime
    public int getMin() {
        return Arrays.stream(dataService1.retrieveData()).min().orElse(Integer.MAX_VALUE);
    }
}
