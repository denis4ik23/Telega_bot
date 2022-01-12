package ru.denis4ik23bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.denis4ik23bot.core.CoreBot;

public class MainBot {
    public static void main(String[] args) {
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


    }
}
