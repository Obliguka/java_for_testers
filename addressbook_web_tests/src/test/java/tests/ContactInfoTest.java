package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTest extends TestBase{
    @Test
    void testPhones(){

        var contacts=app.hbm().getContactList();
        var expected=contacts.stream().collect(Collectors.toMap(contact -> contact.id(), contact->
            Stream.of(contact.home(), contact.mobile(), contact.work(), contact.secondary()).
                    filter(s->s!=null && !"".equals(s)).
                    collect(Collectors.joining("\n"))
        ));
        var phones=app.contact().getPhones();
        Assertions.assertEquals(expected, phones);

        /*for(var contact:contacts){
            var expected= Stream.of(contact.home(), contact.mobile(), contact.work(), contact.secondary()).
                    filter(s->s!=null && !"".equals(s)).
                    collect(Collectors.joining("\n"));
            Assertions.assertEquals(expected, phones.get(contact.id()));
        }*/
    }

    @Test
    void testEmails(){
        var contacts=app.hbm().getContactList();
        var contact=contacts.get(0);

        var emails=app.contact().getEmails(contact);
        var expected=Stream.of(contact.email(),contact.email2(),contact.email3()).
                filter(s->s!=null && !s.equals("")).
                collect(Collectors.joining("\n"));

        Assertions.assertEquals(expected, emails);

    }

    @Test
    void testAddress(){
        var contacts=app.hbm().getContactList();
        var contact=contacts.get(0);

        var address=app.contact().getAddress(contact);
        var expected=Stream.of(contact.address()).
                filter(s->s!=null && !s.equals("")).
                collect(Collectors.joining("\n"));

        Assertions.assertEquals(expected, address);

    }

}
