package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class CreationContactTests extends TestBase {

  @Test
  public void canCreatedContact()
  {
    TestBase.app.contact().createdContact(new ContactData("firstname", "middlename", "lastname",
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
    TestBase.app.contact().createdContact(new ContactData().withFirstName("name_only"));
  }

  @Test
  public void canCreatedContactWithAddressOnly()
  {
    TestBase.app.contact().createdContact(new ContactData().withAddress("address_only"));
  }

  @Test
  public void canCreatedContactWithLastnameOnly()
  {
    TestBase.app.contact().createdContact(new ContactData().withLastName("lastname_only"));
  }


}
