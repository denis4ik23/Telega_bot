package ru.denis4ik23bot.core;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static ru.denis4ik23bot.constant.VarConst.START;

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
    //обрабатывает сообщения от пользователя и отвечает
    @Override
    public void onUpdateReceived(Update update) {
        //если это сообщение
        if(update.hasMessage() && update.getMessage().hasText()){
            //обрабатываем команды
            switch (update.getMessage().getText()){
                case START:
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));//приводим Long к String
                    sendMessage.setText("Test");
                    try {
                        execute(sendMessage);//отправить сообщение
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

            }

        }
        System.out.println("test hello");
    }
}
