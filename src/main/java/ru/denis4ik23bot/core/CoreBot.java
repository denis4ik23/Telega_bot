package ru.denis4ik23bot.core;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
//создаем ядро бота
public class CoreBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }
    //обрабатывает сообщения от пользователя и отвечать
    @Override
    public void onUpdateReceived(Update update) {

    }
}
