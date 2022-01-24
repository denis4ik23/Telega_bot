package ru.denis4ik23bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import static java.util.Arrays.asList;

import static ru.denis4ik23bot.constant.VarConst.*;

public class SendMassageOperationService {
    // приветствие бота при команде /start
    private final String GREETING_MASSAGE = "Привет";
    private final String HELP_ME = "Мне бы кто помог";
    private final String SETTINGS = "Сейчас как настрою";

    private final ButtonsService buttonsService = new ButtonsService();

    public SendMessage createGreetingMessage(Update update){
        SendMessage massage = createMessage(update, GREETING_MASSAGE);
        ReplyKeyboardMarkup keyboardMarkup =
                buttonsService.setButtons(buttonsService.createButtons(
                        asList(WEATHER_NOW, HELP, SETTINGS_BOT)));
        massage.setReplyMarkup(keyboardMarkup);
        return massage;
    }

    public SendMessage createStartBotMessage(Update update, String startMassage){
        return createMessage(update, startMassage);
    }

    public SendMessage createStopBotMessage(Update update){
        return createMessage(update, HELP_ME);
    }

    public SendMessage createShowMessage(Update update){
        return createMessage(update, SETTINGS);
    }

    private SendMessage createMessage(Update update, String massage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText(massage);
        return sendMessage;
    }
}
