package ru.denis4ik23bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import static java.util.Arrays.asList;
import static ru.denis4ik23bot.constant.VarConst.*;

public class SendMassageOperationService {
    // приветствие бота при команде /start
    private final String GREETING_MASSAGE = "Привет";
    private final String START_MASSAGE = "Старт";
    private final String STOP_MASSAGE = "Стоп";

    private final ButtonsService buttonsService = new ButtonsService();

    public SendMessage createGreetingMessage(Update update){
        SendMessage massage = createMassage(update, GREETING_MASSAGE);
        ReplyKeyboardMarkup keyboardMarkup =
                buttonsService.setButtons(buttonsService.createButtons(
                        asList(START_BOT, STOP_BOT, SHOW_ME)));
        massage.setReplyMarkup(keyboardMarkup);
        return massage;
    }

    public SendMessage createStartBotMessage(Update update){
        return createMassage(update, START_MASSAGE);
    }

    public SendMessage createStopBotMessage(Update update){
        return createMassage(update, STOP_MASSAGE);
    }

    private SendMessage createMassage(Update update, String massage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText(massage);
        return sendMessage;
    }
}
