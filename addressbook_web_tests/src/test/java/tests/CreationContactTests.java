package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreationContactTests extends TestBase {

  public static List<ContactData> contactProvider() throws IOException {
    var result=new ArrayList<ContactData>();

    /*for (var firstname: List.of("","contact firstname")) {
      for (var address : List.of("", "contact middlename")) {
        for (var lastname : List.of("", "contact lastname")) {

            result.add(new ContactData("",firstname, "", lastname, "", address, "", "", "", "", ""));

        }
      }
    }*/

    var json="";
    try (var resder=new FileReader("contacts.xml");
         var breader=new BufferedReader(resder))
    {
      var line= breader.readLine();
      while(line !=null){
        json=json+line;
        line=breader.readLine();
      }

    }

    /*for(int i=0;i<1;i++)
    {
      result.add(new ContactData("", CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3),
              CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3),
              CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3), CommonFunctions.randomString(i*3),
              CommonFunctions.randomString(i*3), ""));
    }*/
    var mapper = new XmlMapper();
    var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {});
    //var value = mapper.readValue(new File("groups.json"), new TypeReference <List<GroupData>>() {});
    result.addAll(value);

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
      app.contact().createdContactWithoutPhoto(contact);
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
