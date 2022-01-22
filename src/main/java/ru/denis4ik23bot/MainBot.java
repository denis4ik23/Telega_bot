package ru.denis4ik23bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import ru.denis4ik23bot.core.CoreBot;
import ru.denis4ik23bot.parseapi.GsonParser;
import ru.denis4ik23bot.parseapi.Root;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainBot {
    public static String stringWeather;
    private static final String API_CALL_TEMPLATE = "https://api.openweathermap.org/data/2.5/weather?q=";
    public static String city = "Санкт-Петербург";
    private static final String LANG_RU = "&lang=ru";//ввод названия города на русском
    private static final String TEMPERATURE_CELSIUS = "&units=metric";//температура в градусах цельсия
    private static final String API_KEY = "&appid=77bafaa41ca5deb9d1c5e6e6b416d395";
    public static void main(String[] args) throws IOException {
        //инициализация бота
        TelegramBotsApi botsApi = null;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            //регистрация бота
            //реализация бота через LongPollingBot или WebhookBot
            //делаем через LongPollingBot, который реалезован в классе CoreBot
            botsApi.registerBot(new CoreBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        readApiWeather();

        GsonParser gsonParser = new GsonParser();
        Root root = gsonParser.parse();

        //System.out.println("Температура " + (int) (gsonParser.parse().));
        //System.out.println("Ощущается как " + (int) (root.main.getFeelsLike()));
        //System.out.println("Максимальная температура " + (int) (root.main.getTempMax()));
        //System.out.println("Минимальная температура " + (int) (root.main.getTempMin()));
        //System.out.println("Давление " + ((int) root.main.getPressure()));
        //System.out.println("Влажность " + ((int) root.main.getHumidity()));
        //System.out.println("Скорость ветра " + ((int) root.wind.getSpeed()));

    }

    private static void readApiWeather() throws IOException {
        String urlString = API_CALL_TEMPLATE + city + LANG_RU + TEMPERATURE_CELSIUS + API_KEY;

        URL urlObject = new URL(urlString);//создаём объект который будет содержать ссылку
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();//создаём соединение, используя объект
        connection.setRequestMethod("GET");//выбираем тип запроса (GET)

        // создаём поток, вычитываем все строки, и склеиваем в одну большую строку,
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        stringWeather = response.toString();
        //System.out.println(stringWeather);
    }
}
