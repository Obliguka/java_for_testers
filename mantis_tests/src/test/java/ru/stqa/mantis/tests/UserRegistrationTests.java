package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;

public class UserRegistrationTests extends TestBase{
    @Test
    void canRegisterUser(String username){
        var email=String.format("%s@localhost",username);
        //создать пользователя на почтовом сервере (JamesHelper)
        //заполняем форму создания пользователя в браузере и отправляем Б
        //ждем почту (MailHelper)
        //извлекаем ссылку
        //возвращаемся в браузер, проходим по ссылке Б
        //завершаем регистрацию
        //проверяем что пользователь может залогиниться (HttpSessionHelper)

        //для действий через браузер нужно создать класс помощник
    }
}
