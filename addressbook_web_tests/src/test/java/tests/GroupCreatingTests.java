package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreatingTests extends TestBase {

    @Test
    public void canCreatedGroup() {
        int groupCount=app.groups().getCount();
        app.groups().createdGroup(new GroupData("name", "header", "footer"));
        int newGroupCount=app.groups().getCount();
        Assertions.assertEquals(groupCount+1,newGroupCount);

    }

    @Test
    public void canCreatedGroupWithEmptyName() {


        app.groups().createdGroup(new GroupData("", "", ""));
    }

    @Test
    public void canCreatedGroupWithNameOnly() {


        app.groups().createdGroup(new GroupData().withName("some Name"));
    }
}
