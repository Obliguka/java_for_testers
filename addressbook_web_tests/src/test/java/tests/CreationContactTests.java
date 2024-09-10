package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
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

    for(int i=0;i<2;i++)
    {
      result.add(new ContactData("",randomString(i*3),randomString(i*3),
              randomString(i*3), randomString(i*3),randomString(i*3),
              randomString(i*3),randomString(i*3),randomString(i*3),
              randomString(i*3)));
    }
    return result;

  }

  @ParameterizedTest
  @MethodSource("contactProvider")
  public void canCreatedContacts(ContactData contact)
    {
    /*int contactCount=app.contact().getCount();
    app.contact().createdContact(contact);
    int newContactCount=app.contact().getCount();
    Assertions.assertEquals(contactCount+1,newContactCount);*/
      var oldContacts=app.contact().getList();
      app.contact().createdContact(contact);
      var newContacts=app.contact().getList();
      var expectedList=new ArrayList<>(oldContacts);

      Comparator<ContactData> compareById = (o1, o2) -> {
        return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));

      };
      newContacts.sort(compareById);
      expectedList.add(contact.withId(newContacts.get(newContacts.size()-1).id()).withAddress("").withLastName(""));
      expectedList.sort(compareById);
      Assertions.assertEquals(newContacts,expectedList);

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
