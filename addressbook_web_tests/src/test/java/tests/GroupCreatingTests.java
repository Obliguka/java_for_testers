package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;


public class GroupCreatingTests extends TestBase {

    public static List<GroupData> groupProvider() {
        var result=new ArrayList<GroupData>();

        for (var name: List.of("","group name")){
            for (var header : List.of("","group header")){
                for (var footer : List.of("","group footer")){
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }

        for(int i=0;i<5;i++)
        {
            result.add(new GroupData().
                    withName(randomString(i*10)).
                    withHeader(randomString(i*10)).
                    withFooter(randomString(i*10)));
        }
        return result;

    }

  /*  @ParameterizedTest
    @ValueSource(strings={"group_name","group_name'"})
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
    }*/

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreatedMultipleGroups(GroupData group) {
        int groupCount=app.groups().getCount();
        app.groups().createdGroup(group);
        int newGroupCount=app.groups().getCount();
        Assertions.assertEquals(groupCount+1,newGroupCount);

    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "group_name'", "", "")));
        return result;
    }
        @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreatedGroup(GroupData group) {
        int groupCount=app.groups().getCount();
        app.groups().createdGroup(group);
        int newGroupCount=app.groups().getCount();
        Assertions.assertEquals(groupCount,newGroupCount);

    }
}
