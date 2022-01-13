package ru.denis4ik23bot.core;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
//создаем ядро бота
public class CoreBot extends TelegramLongPollingBot {
    //метод возвращает username который указали при регистрации
    @Override
    public String getBotUsername() {
        return "denis4ik23_bot";
    }//username
    //метод возвращает токен который дали при регистрации
    @Override
    public String getBotToken() {
        return "5038609304:AAE13S9XauNgaEWY9Am6DU2rgk00jSjrJ1A";//токен
    }
    //обрабатывает сообщения от пользователя и отвечать
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("test");
    }
}
