package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase {
  @Test
  public void canRemovalContact() {

   if (app.contact().getCount()==0){
    app.contact().createdContact(new ContactData("","",
            "", "", "","","",
            "","","", ""));
  }
 // int contactCount=app.contact().getCount();
   List <ContactData> oldContacts=app.contact().getList();
  var rnd=new Random();
  var index=rnd.nextInt(oldContacts.size());

  app.contact().removalContact(oldContacts.get(index));
  List<ContactData> newContacts=app.contact().getList();
  var expectedList=new ArrayList<>(oldContacts);
        expectedList.remove(index);

  //int newGroupCount=app.contact().getCount();
  Assertions.assertEquals(newContacts,expectedList);
}

    @Test
    void canRemovalAllContactsAtOnce(){
        if (app.contact().getCount()==0){
            app.contact().createdContact(new ContactData("",
                    "","","","",
                    "","", "", "", "", ""));
        }
        app.contact().removeAllContacts();
        Assertions.assertEquals(0,app.contact().getCount());

    }

}
