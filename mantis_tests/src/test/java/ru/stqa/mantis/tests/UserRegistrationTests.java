package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;



public class UserRegistrationTests extends TestBase{
    @ParameterizedTest
    @ValueSource(strings = {"testuser8"})
    void canRegisterUser(String username) throws InterruptedException {
        var email=String.format("%s@localhost",username);
        //создать пользователя на почтовом сервере (JamesHelper)
        app.jamesCli().addUser(email,"password");

        //заполняем форму создания пользователя в браузере и отправляем Б
        app.browser().fillFormForUsers(username,email);
        Thread.sleep(1000);

        //ждем почту (MailHelper)
        var messages= app.mail().recieve(email,
                "password",
                Duration.ofSeconds(10));

        //извлекаем ссылку
        Thread.sleep(1000);
        var url=app.mail().canExtractUrl(email, "password");
        Assertions.assertEquals(1,messages.size());

        //возвращаемся в браузер, проходим по ссылке Б
        app.browser().finalRegistrationUser(username,"password", url);

        //завершаем регистрацию
        //проверяем что пользователь может залогиниться (HttpSessionHelper)
        app.http().login(username, "password");
        Assertions.assertTrue(app.http().isLoggedIn());

        app.mail().drain(email, "password");

    }

    @ParameterizedTest
    @ValueSource(strings = {"testuser9"})
    void canCreateUser(String username) throws InterruptedException {
        var email=String.format("%s@localhost",username);
        app.jamesApi().addUser(email,"password");

        //заполняем форму создания пользователя в браузере и отправляем Б
        app.browser().fillFormForUsers(username,email);
        Thread.sleep(1000);

        //ждем почту (MailHelper)
        var messages= app.mail().recieve(email,
                "password",
                Duration.ofSeconds(10));

        //извлекаем ссылку
        Thread.sleep(1000);
        var url=app.mail().canExtractUrl(email, "password");
        Assertions.assertEquals(1,messages.size());

        //возвращаемся в браузер, проходим по ссылке Б
        app.browser().finalRegistrationUser(username,"password", url);

        //завершаем регистрацию
        //проверяем что пользователь может залогиниться (HttpSessionHelper)
        app.http().login(username, "password");
        Assertions.assertTrue(app.http().isLoggedIn());

        app.mail().drain(email, "password");

    }
}
