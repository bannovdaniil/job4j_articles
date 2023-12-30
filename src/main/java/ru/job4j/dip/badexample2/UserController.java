package ru.job4j.dip.badexample2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Нарушение принципа DIP, контроллер зависит от реализации, а не от абстракции.
 * Если Пользователей понадобится хранить в базе данных придется менять весь код,
 * если будет абстракциия тогда заменится один модуль.
 */
public class UserController {
    private final List<User> userList = new ArrayList<>();
    private final Gson gson = new GsonBuilder().create();

    public String showUser() {
        return gson.toJson(userList);
    }
}
