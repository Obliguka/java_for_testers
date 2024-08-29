package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GroupCreatingTests extends TestBase {
    @ParameterizedTest
    @ValueSourse(strings={"group_name", "group_name'"})
    public void canCreatedGroup(String name) {
        int groupCount=app.groups().getCount();
        app.groups().createdGroup(new GroupData(name, "header", "footer"));
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

    @Test
    public void canCreatedMultipleGroups() {
        int n=5;

        int groupCount=app.groups().getCount();

        for(int i=0;i<n;i++)
        {
            app.groups().createdGroup(new GroupData(randomString(i), "header", "footer"));
        }

        int newGroupCount=app.groups().getCount();
        Assertions.assertEquals(groupCount+n,newGroupCount);

    }
}
