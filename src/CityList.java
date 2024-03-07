import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CityList {
    private List<City> cities = new ArrayList<>();

    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists in the list.");
        }
        cities.add(city);
    }

    public void delete(City city) {
        if (!cities.remove(city)) {
            throw new IllegalArgumentException("City does not exist in the list.");
        }
    }

    public int count() {
        return cities.size();
    }

    public List<City> getCities(boolean sortByCityName) {
        List<City> cityList = new ArrayList<>(cities);
        if (sortByCityName) {
            cityList.sort(Comparator.comparing(City::getCityName));
        } else {
            cityList.sort(Comparator.comparing(City::getProvinceName));
        }
        return cityList;
    }

    public List<City> getCitiesSortedByName() {
        return getCities(true);
    }

    public List<City> getCitiesSortedByProvince() {
        return getCities(false);
    }
}
