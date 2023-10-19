package Netology.i18n;

import Netology.enity.Country;
import Netology.i18n.LocalizationService;

public class LocalizationServiceImpl implements LocalizationService {
    public String locale(Country country) {
        switch (country) {
            case RUSSIA:
                return "Добро пожаловать";
            default:
                return "Welcome";
        }
    }
}
