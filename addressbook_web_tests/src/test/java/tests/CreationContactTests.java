package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreationContactTests extends TestBase {

  public static List<ContactData> contactProvider() {
    var result=new ArrayList<ContactData>();

    for (var firstname: List.of("","contact firstname")) {
      for (var address : List.of("", "contact middlename")) {
        for (var lastname : List.of("", "contact lastname")) {

            result.add(new ContactData("",firstname, "", lastname, "", address, "", "", "", "", ""));

        }
      }
    }

    for(int i=0;i<1;i++)
    {
      result.add(new ContactData("", CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3),
              CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3),
              CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3),
              CommonFunctions.randomString(i*3), ""));
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
      expectedList.add(contact.withId(newContacts.get(newContacts.size()-1).id()));
      expectedList.sort(compareById);
      Assertions.assertEquals(newContacts,expectedList);

  }

  @Test
  public void canCreatedContactWithPhoto()
  {
    var contact=new ContactData().
            withFirstName(CommonFunctions.randomString(10)).
            withLastName(CommonFunctions.randomString(10)).
            withPhoto(randomFile("src/test/resources/images"));
    app.contact().createdContact(contact);
  }/*
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
