package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreatingTests extends TestBase {

    @Test
    public void canCreatedGroup() {
        app.groups().createdGroup(new GroupData("name", "header", "footer"));

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
