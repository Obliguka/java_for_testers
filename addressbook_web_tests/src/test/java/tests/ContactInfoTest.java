package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class ContactInfoTest extends TestBase{
    @Test
    void testPhones(){
        var contacts=app.hbm().getContactList();
        var contact=contacts.get(0);
        var phones=app.contact().getPhones(contact);
        var expected= Stream.of(contact.home(), contact.mobile(), contact.work(), contact.secondary()).
                filter(s->s!=null && !"".equals(s));
        Assertions.assertEquals(expected, phones);
    }

}
