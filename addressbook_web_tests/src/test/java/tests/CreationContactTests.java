package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class CreationContactTests extends TestBase {

  public static List<ContactData> contactProvider() {
    var result=new ArrayList<ContactData>();

    for (var firstname: List.of("","contact firstname")) {
      for (var middlename : List.of("", "contact middlename")) {
        for (var lastname : List.of("", "contact lastname")) {
          for (var nickname : List.of("", "contact nickname")) {
            result.add(new ContactData("",firstname, middlename, lastname, nickname, "", "", "", "", ""));
          }
        }
      }
    }

    for(int i=0;i<5;i++)
    {
      result.add(new ContactData("",randomString(i*10),randomString(i*10),
              randomString(i*10), randomString(i*10),randomString(i*10),
              randomString(i*10),randomString(i*10),randomString(i*10),
              randomString(i*10)));
    }
    return result;

  }

  @ParameterizedTest
  @MethodSource("contactProvider")
  public void canCreatedContacts(ContactData contact)
    {
    int contactCount=app.contact().getCount();
    app.contact().createdContact(contact);
    int newContactCount=app.contact().getCount();
    Assertions.assertEquals(contactCount+1,newContactCount);

  }

  /*@Test
  public void canCreatedContact()
  {
    app.contact().createdContact(new ContactData("firstname", "middlename", "lastname",
            "nickname","address","home","mobile","work","email@rr.com"));
  }
  @Test
  public void canCreatedContactWithEmptyFields()
  {
    TestBase.app.contact().createdContact(new ContactData());
  }

  @Test
  public void canCreatedContactWithNameOnly()
  {
    app.contact().createdContact(new ContactData().withFirstName("name_only"));
  }

  @Test
  public void canCreatedContactWithAddressOnly()
  {
    app.contact().createdContact(new ContactData().withAddress("address_only"));
  }

  @Test
  public void canCreatedContactWithLastnameOnly()
  {
    app.contact().createdContact(new ContactData().withLastName("lastname_only"));
  }*/


}
