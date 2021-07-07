package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
// Bean
@RequestMapping("/names")
public class CountryNameController
{
    //   "/all"
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAllCountryNames()
    {
        return new ResponseEntity<>(CountriesApplication.myCountryList.countryList, HttpStatus.OK);
    }

    //   "/start/{letter}"
    @GetMapping(value = "/start/{letter}", produces = "application/json")
    public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter)
    {
        // array list
        ArrayList<Country> countries = CountriesApplication.myCountryList.findCountries(c ->
                c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        // sort
        countries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    //   "/size/{number}"
    @GetMapping(value = "/size/{number}", produces = "application/json")
    public ResponseEntity<?> getCountriesBySize(@PathVariable int number)
    {
        // array list
        ArrayList<Country> countries = CountriesApplication.myCountryList.findCountries(c ->
                c.getName().length() >= number);
        // sort
        countries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}
