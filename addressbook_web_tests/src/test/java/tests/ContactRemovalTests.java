package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;
import tests.TestBase;
public class ContactRemovalTests extends TestBase {
  @Test
  public void canRemovalContact() {
    if (!TestBase.app.contact().isContactPresent()){
      TestBase.app.contact().createdContact(new ContactData());
    }
    TestBase.app.contact().removalContact();
  }
}
