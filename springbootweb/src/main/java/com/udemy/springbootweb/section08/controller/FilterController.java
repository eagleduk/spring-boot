package com.udemy.springbootweb.section08.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.udemy.springbootweb.section08.bean.FilterBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilterController {
    @GetMapping("/filter")
    public MappingJacksonValue getFilter() {

        FilterBean filterBean = new FilterBean("value1", "value2", "value3", "value4", "value5", "value6");

        // Dynamic Filter
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filterBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("property3", "property4");
        FilterProvider filters = new SimpleFilterProvider().addFilter("ResponseFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/filter-list")
    public MappingJacksonValue getFilterList() {
        List<FilterBean> list = List.of(new FilterBean("value1", "value2", "value3", "value4", "value5", "value6"),
                new FilterBean("value7", "value8", "value9", "value10", "value11", "value12"));

        // Dynamic Filter
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("property4", "first_name", "last_name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("ResponseFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
