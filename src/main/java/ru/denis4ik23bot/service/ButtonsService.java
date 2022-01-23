package ru.denis4ik23bot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

//добавляем кнопки
public class ButtonsService {
    //метод обертка для кнопок
    //передаем кнопки, а метод устанавливает свойства
    public ReplyKeyboardMarkup setButtons(List<KeyboardRow> keyboardRowList){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);//подбирает клавиатуру под разные типы устройства
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        return replyKeyboardMarkup;
    }
    //создаем кнопки
    //передаем в параметры название кнопок
    public List<KeyboardRow> createButtons(List<String> buttonsName){
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();//одна полоска с кнопками
        for(String buttonName : buttonsName){
            keyboardRow.add(new KeyboardButton(buttonName));
        }
        keyboardRows.add(keyboardRow);
        return keyboardRows;
    }
}