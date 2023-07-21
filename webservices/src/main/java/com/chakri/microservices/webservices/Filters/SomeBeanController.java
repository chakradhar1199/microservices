package com.chakri.microservices.webservices.Filters;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeBeanController {

    @GetMapping("/filtering")
    public MappingJacksonValue getBean() {
        SomeBean s = new SomeBean("chakradhar", "reddy");
        MappingJacksonValue map = new MappingJacksonValue(s);

        SimpleBeanPropertyFilter beanPropertyFilter = SimpleBeanPropertyFilter
                .filterOutAllExcept("value2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", beanPropertyFilter);
        map.setFilters(filterProvider);
        return map;
    }
}
