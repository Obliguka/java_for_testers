package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class CreationContactTests extends TestBase {

  @Test
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
  }


}
