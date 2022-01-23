package ru.denis4ik23bot.parseapi;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//используем библиотеку Lombok
@AllArgsConstructor//аннотация для создания конструктора
@Getter//создаем гетеры для доступа
@Setter//создаем сетеры для записи данных библиотекой Gson
public class Main {
    private double temp;
    //аннотация библиотеки Gson
    @SerializedName("feels_like")//когда названия переменных не совпадают
    // говорим библиотеке Gson куда записать данные
    private double feelsLike;
    @SerializedName("temp_min")
    private double tempMin;
    @SerializedName("temp_max")
    private double tempMax;
    private double pressure;
    private double humidity;
}
