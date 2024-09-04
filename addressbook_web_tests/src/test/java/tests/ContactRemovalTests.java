package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;
public class ContactRemovalTests extends TestBase {
  @Test
  public void canRemovalContact() {
    if (!app.contact().isContactPresent()){
      app.contact().createdContact(new ContactData());
    }

      app.contact().removalContact();
  }
}
