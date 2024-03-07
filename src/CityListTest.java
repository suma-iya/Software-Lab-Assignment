import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CityListTest {

    private CityList cityList;

    @BeforeEach
    void setUp() {
        cityList = new CityList();
        // Add some cities for testing
        cityList.add(new City("City A", "Province 1"));
        cityList.add(new City("City B", "Province 2"));
        cityList.add(new City("City C", "Province 3"));
    }



    @Test
    void testDeleteException() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                cityList.delete(new City("Nonexistent City", "Province")));
    }

    @Test
    void testCount() {
        Assertions.assertEquals(3, cityList.count());
    }

    @Test
    void testSortByName() {
        List<City> sortedList = cityList.getCitiesSortedByName();
        Assertions.assertEquals("City A", sortedList.get(0).getCityName());
        Assertions.assertEquals("City B", sortedList.get(1).getCityName());
        Assertions.assertEquals("City C", sortedList.get(2).getCityName());
    }

    @Test
    void testSortByProvince() {
        List<City> sortedList = cityList.getCitiesSortedByProvince();
        Assertions.assertEquals("City B", sortedList.get(1).getCityName());
        Assertions.assertEquals("City A", sortedList.get(0).getCityName());
        Assertions.assertEquals("City C", sortedList.get(2).getCityName());
    }
}