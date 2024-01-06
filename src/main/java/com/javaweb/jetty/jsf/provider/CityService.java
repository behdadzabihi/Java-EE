package com.javaweb.jetty.jsf.provider;

import com.nikamooz.javaweb.session7.entity.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityService {

    Map<Integer, City> cities;

    public CityService(){
        cities = new HashMap<>();
        cities.put(1, new City(1, "Tehran"));
        cities.put(2, new City(2, "Isfahan"));
        cities.put(3, new City(3, "Shiraz"));
        cities.put(4, new City(4, "Mashhad"));
        cities.put(5, new City(5, "Ahwaz"));
        cities.put(6, new City(6, "Abadan"));
        cities.put(7, new City(7, "Tabriz"));
    }

    public List<City> getCities(){
        return new ArrayList<>(cities.values());
    }

    public City getById(Integer id){
        return cities.get(id);
    }


}
