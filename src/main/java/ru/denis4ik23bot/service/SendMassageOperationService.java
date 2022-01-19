package ru.denis4ik23bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SendMassageOperationService {

    private final String greetingMassage = "Привет";

    public SendMessage createGreetingMessage(Update update){

        return createMassage(update, greetingMassage);
    }

    private SendMessage createMassage(Update update, String massage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText(massage);
        return sendMessage;
    }
}
