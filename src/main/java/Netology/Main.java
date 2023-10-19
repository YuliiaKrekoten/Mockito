package Netology;

import Netology.geo.GeoService;
import Netology.geo.GeoServiceImpl;
import Netology.i18n.LocalizationService;
import Netology.i18n.LocalizationServiceImpl;
import Netology.sender.MessageSender;
import Netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        messageSender.send(headers);
    }
}