package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
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

    @Test
    public void canRemovalContactFromBD() {

        if (app.hbm().getContactCount()==0){
            app.hbm().createdContact(new ContactData("","",
                    "", "", "","","",
                    "","","", ""));
        }
        // int contactCount=app.contact().getCount();
        List <ContactData> oldContacts=app.hbm().getContactList();
        var rnd=new Random();
        var index=rnd.nextInt(oldContacts.size());

        app.contact().removalContact(oldContacts.get(index));
        List<ContactData> newContacts=app.hbm().getContactList();
        var expectedList=new ArrayList<>(oldContacts);
        expectedList.remove(index);

        //int newGroupCount=app.contact().getCount();
        Assertions.assertEquals(newContacts,expectedList);
    }

    @Test
    public void canRemovalContactInGroup() throws SQLException {

        if (app.hbm().getContactCount()==0){
            app.hbm().createdContact(new ContactData("","",
                    "", "", "","","",
                    "","","", ""));
        }

        if (app.hbm().getGroupCount()==0){
            app.hbm().createdGroup(new GroupData("", "", "", ""));
        }

        var group=app.hbm().getGroupList().get(0);
        var contact=app.hbm().getContactList().get(0);

        var oldRelated=app.hbm().getContactsInGroup(group);

        if(oldRelated.size()==0){
            app.contact().create(contact, group);
            oldRelated=app.hbm().getContactsInGroup(group);
        }

        //var oldRelated1=app.hbm().getContactsInGroup(group);

        app.jdbc().removeContactInGroup(Integer.parseInt(group.id()));

        var newRelated=app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size()-1,newRelated.size());
    }

}
