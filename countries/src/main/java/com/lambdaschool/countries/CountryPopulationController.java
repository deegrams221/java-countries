package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController
{
    //  "/size/{people}"
    @GetMapping(value = "/size/{people}", produces = "application/json")
    public ResponseEntity<?> getCountriesByNameLength(@PathVariable long people)
    {
        // array list
        ArrayList<Country> countries = CountriesApplication.myCountryList.findCountries(c -> c.getPopulation() >= people);
        countries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    //  "/min"
    @GetMapping(value = "/min", produces = "application/json")
    public ResponseEntity<?> findMinPopulation()
    {
        // array list
        ArrayList<Country> countries = (ArrayList) CountriesApplication.myCountryList.countryList;
        countries.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(countries.get(0), HttpStatus.OK);
    }

    //  "/max"
    @GetMapping(value = "/max", produces = "application/json")
    public ResponseEntity<?> findMaxPopulation()
    {
        // array list
        ArrayList<Country> countries = (ArrayList) CountriesApplication.myCountryList.countryList;
        countries.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(countries.get(0), HttpStatus.OK);
    }

    //  "/median" - Stretch Goal
    @GetMapping(value = "/median", produces = "application/json")
    public ResponseEntity<?> findMedianPopulation()
    {
        // array list
        ArrayList<Country> countries = (ArrayList) CountriesApplication.myCountryList.countryList;
        countries.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        int medianCountries = countries.size() / 2;
        return new ResponseEntity<>(countries.get(medianCountries), HttpStatus.OK);
    }
}

