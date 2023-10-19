package Netology.sender;




import Netology.enity.Country;
import Netology.enity.Location;
import Netology.geo.GeoService;
import Netology.i18n.LocalizationService;
import Netology.sender.MessageSender;
import Netology.sender.MessageSenderImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class MessageSenderTest {

    @Test
    public void testSendRussianMessage() {
        // Создаем мок объект GeoService
        GeoService geoService = Mockito.mock(GeoService.class);
        // Задаем поведение мок объекта: всегда возвращать российскую локацию
        when(geoService.byIp(anyString())).thenReturn(new Location("Russia"));

        // Создаем мок объект LocalizationService
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        // Задаем поведение мок объекта: всегда возвращать русский текст
        when(localizationService.locale(Country.valueOf("Russia"))).thenReturn("Привет");

        // Создаем объект MessageSenderImpl и передаем ему мок объекты
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        // Создаем заголовки с российским IP-адресом
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "192.168.0.1");

        // Вызываем метод send()
        String result = messageSender.send(headers);

        // Проверяем, что результат соответствует ожидаемому русскому тексту
        assertEquals("Привет", result);
    }

    @Test
    public void testSendEnglishMessage() {
        // Создаем мок объект GeoService
        GeoService geoService = Mockito.mock(GeoService.class);
        // Задаем поведение мок объекта: всегда возвращать американскую локацию
        when(geoService.byIp(anyString())).thenReturn(new Location("USA"));

        // Создаем мок объект LocalizationService
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        // Задаем поведение мок объекта: всегда возвращать английский текст
        when(localizationService.locale(Country.valueOf("USA"))).thenReturn("Hello");

        // Создаем объект MessageSenderImpl и передаем ему мок объекты
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        // Создаем заголовки с американским IP-адресом
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "123.456.789.0");

        // Вызываем метод send()
        String result = messageSender.send(headers);

        // Проверяем, что результат соответствует ожидаемому английскому тексту
        assertEquals("Hello", result);
    }
}
