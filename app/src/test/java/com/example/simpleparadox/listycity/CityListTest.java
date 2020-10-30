package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetProvince(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        String p=cityList.getProvince(city);
        assertEquals("Northwest Territories",p);
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }
    @Test
    void testCountCities() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());
    }
}
