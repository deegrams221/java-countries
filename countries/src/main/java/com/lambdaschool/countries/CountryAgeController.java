package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController
{
    //   "/age/{age}"
    @GetMapping(value = "/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByMedianAge(@PathVariable int age)
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries = CountriesApplication.myCountryList.findCountries(c -> c.getMedianAge() >= age);
        countries.sort((c1, c2) -> c2.getMedianAge() - c1.getMedianAge());
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    //  "/min"
    @GetMapping(value = "/min", produces = "application/json")
    public ResponseEntity<?> getMinAges()
    {
        ArrayList<Country> countries = (ArrayList) CountriesApplication.myCountryList.countryList;
        countries.sort((c1, c2) -> c1.getMedianAge() - c2.getMedianAge());
        return new ResponseEntity<>(countries.get(0), HttpStatus.OK);
    }

    //   "/max"
    @GetMapping(value = "/max", produces = "application/json")
    public ResponseEntity<?> getMaxAges()
    {
        ArrayList<Country> countries = (ArrayList) CountriesApplication.myCountryList.countryList;
        countries.sort((c1, c2) -> c2.getMedianAge() - c1.getMedianAge());
        return new ResponseEntity<>(countries.get(0), HttpStatus.OK);
    }

    //   "/median"
    @GetMapping(value = "/median", produces = "application/json")
    public ResponseEntity<?> getMedianAges()
    {
        ArrayList<Country> countries = (ArrayList) CountriesApplication.myCountryList.countryList;
        countries.sort((c1, c2) -> c2.getMedianAge() - c1.getMedianAge());
        int medianCountries = countries.size() / 2;
        return new ResponseEntity<>(countries.get(medianCountries), HttpStatus.OK);
    }
}
