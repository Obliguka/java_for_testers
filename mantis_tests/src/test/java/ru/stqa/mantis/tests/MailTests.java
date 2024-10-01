package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.regex.Pattern;

public class MailTests extends TestBase{
    @Test
    void canDrainInbox(){
        app.mail().drain("testuser1@localhost", "password");
    }

    @Test
    void canRecieveEmail(){
        var messages= app.mail().recieve("testuser4@localhost",
                "password",
                Duration.ofSeconds(10));
        Assertions.assertEquals(1,messages.size());
        System.out.println(messages);
    }

    @Test
    void canExtractUrl(){
        var messages= app.mail().recieve("user1@localhost",
                "password",
                Duration.ofSeconds(10));
        var text=messages.get(0).content();
        var pattern=Pattern.compile("http://\\S*");
        var mattcher=pattern.matcher(text);
        if(mattcher.find()){
            var url=text.substring(mattcher.start(),mattcher.end());
            System.out.println(url);
        }
    }
}
