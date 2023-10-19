package Netology.geo;

import Netology.enity.Location;

public class GeoServiceImpl implements GeoService {
    public static final String LOCALHOST = "127.0.0.1";
    public static final String MOSCOW_IP = "172.0.32.11";
    public static final String NEW_YORK_IP = "96.44.183.149";

    /**
     * Метод определяет локацию по ip
     */
    public Location byIp(String ip) {
        if (LOCALHOST.equals(ip)) {
            return new Location(null);
        } else if (MOSCOW_IP.equals(ip)) {
            return new Location("Moscow");
        } else if (NEW_YORK_IP.equals(ip)) {
            return new Location("New York");
        } else if (ip.startsWith("172.")) {
            return new Location("Moscow");
        } else if (ip.startsWith("96.")) {
            return new Location("New York");
        }
        return null;
    }

    /**
     * Метод определяет локацию по координатам
     */
    public Location byCoordinates(double latitude, double longitude) {
        throw new RuntimeException("Not implemented");
    }
}

