package ru.denis4ik23bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import static java.util.Arrays.asList;
import static ru.denis4ik23bot.constant.VarConst.*;

public class SendMassageOperationService {
    // приветствие бота при команде /start
    private final String greetingMassage = "Привет";
    private final ButtonsService buttonsService = new ButtonsService();

    public SendMessage createGreetingMessage(Update update){
        SendMessage massage = createMassage(update, greetingMassage);
        ReplyKeyboardMarkup keyboardMarkup =
                buttonsService.setButtons(buttonsService.createButtons(
                        asList(START_BOT, STOP_BOT, SHOW_ME)));
        massage.setReplyMarkup(keyboardMarkup);
        return massage;
    }

    private SendMessage createMassage(Update update, String massage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText(massage);
        return sendMessage;
    }
}
