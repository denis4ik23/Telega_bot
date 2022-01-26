package ru.denis4ik23bot.core;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import ru.denis4ik23bot.service.SendMassageOperationService;

import static ru.denis4ik23bot.MainBot.stringRoot;
import static ru.denis4ik23bot.constant.VarConst.*;

//создаем ядро бота
public class CoreBot extends TelegramLongPollingBot {
    SendMassageOperationService sendMassageOperationService = new SendMassageOperationService();

    //метод возвращает username который указали при регистрации
    @Override
    public String getBotUsername() {
        return "denis4ik23_bot";
    }//username
    //метод возвращает токен который дали при регистрации
    @Override
    public String getBotToken() {
        return " ";//токен
    }

    private <T extends BotApiMethod> void executeMessage(T sendMessage){
        try {
            execute(sendMessage);
        }   catch (TelegramApiException e) {
            e.printStackTrace();
            }
    }
    //обрабатывает сообщения от пользователя и отвечает
    @Override
    public void onUpdateReceived(Update update) {
        //если это сообщение
        if(update.hasMessage() && update.getMessage().hasText()){
            //обрабатываем команды
            switch (update.getMessage().getText()){
                case START:
                    //start
                   executeMessage(sendMassageOperationService.createGreetingMessage(update));
                    break;
                case WEATHER_NOW:
                    //погода сейчас
                    executeMessage(sendMassageOperationService.createStartBotMessage(
                            update, stringRoot));//stringRoot
                    break;
                case HELP:
                    //помощь
                    executeMessage(sendMassageOperationService.createStopBotMessage(update));
                    break;
                case SETTINGS_BOT:
                    //настройки
                    executeMessage(sendMassageOperationService.createShowMessage(update));
                    break;
                //default: введите название города
            }
        }
        //тест ответа телеграмма при вводе команды /start и нажатии кнопок
        System.out.println("test hello");
    }
}
