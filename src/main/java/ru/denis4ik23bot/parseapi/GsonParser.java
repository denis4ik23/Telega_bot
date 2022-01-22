package ru.denis4ik23bot.parseapi;

import com.google.gson.Gson;

import static ru.denis4ik23bot.MainBot.stringWeather;

public class GsonParser {
    public Root parse(){
        Gson gson = new Gson();
        Root root = gson.fromJson(stringWeather, Root.class);
        return root;
    }
}
