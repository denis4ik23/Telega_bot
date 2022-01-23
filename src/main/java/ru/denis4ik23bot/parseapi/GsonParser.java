package ru.denis4ik23bot.parseapi;

import com.google.gson.Gson;

import static ru.denis4ik23bot.MainBot.stringWeather;//делаем импорт для доступа

public class GsonParser {
    //парсер с использованием библиотеки Gson
    public Root parse(){
        Gson gson = new Gson();
                                //в параметры принимет
                                //данные считанные с apiWeather в строку
                                // и клас для заполнения нужными данными
        Root root = gson.fromJson(stringWeather, Root.class);
        return root;
    }
}
