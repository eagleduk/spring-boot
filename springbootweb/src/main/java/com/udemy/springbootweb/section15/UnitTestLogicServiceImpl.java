package com.udemy.springbootweb.section15;

public class UnitTestLogicServiceImpl {

    private DataService dataService;

    public UnitTestLogicServiceImpl(DataService d) {
        this.dataService = d;
    }

    public int getMaxValue() {
        int[] dataset = dataService.dataset();

        int maxValue = Integer.MIN_VALUE;
        for(int d: dataset)
            maxValue = Math.max(d, maxValue);

        return maxValue;
    }

}

interface DataService {
    int[] dataset();
}
