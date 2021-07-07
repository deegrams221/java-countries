package com.lambdaschool.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication
{
    // fields
    static CountryList myCountryList;

    public static void main(String[] args)
    {
        // instantiate the object
        myCountryList = new CountryList();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
