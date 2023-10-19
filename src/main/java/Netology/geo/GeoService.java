package Netology.geo;

import Netology.enity.Location;

public interface GeoService {
    Location byIp(String ip);

    Location byCoordinates(double latitude, double longitude);
}
