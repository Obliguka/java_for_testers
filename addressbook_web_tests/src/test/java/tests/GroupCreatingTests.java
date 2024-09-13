package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class GroupCreatingTests extends TestBase {


    public static List<GroupData> groupProvider() throws IOException {
        var result=new ArrayList<GroupData>();

        /*for (var name: List.of("","group name")){
            for (var header : List.of("","group header")){
                for (var footer : List.of("","group footer")){
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }*/

        /*for(int i=0;i<5;i++)
        {
            result.add(new GroupData().
                    withName(CommonFunctions.randomString(i*10)).
                    withHeader(CommonFunctions.randomString(i*10)).
                    withFooter(CommonFunctions.randomString(i*10)));
        }*/
        var json="";
        try (var resder=new FileReader("groups.json");
             var breader=new BufferedReader(resder))
        {
             var line= breader.readLine();
             while(line !=null){
                 json=json+line;
                 line=breader.readLine();
             }

        }
        //var json = Files.readString(Paths.get("groups.json"));
        //ObjectMapper mapper = new ObjectMapper();
        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("groups.xml"), new TypeReference <List<GroupData>>() {});
        //var value = mapper.readValue(new File("groups.json"), new TypeReference <List<GroupData>>() {});
        result.addAll(value);

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
        var oldGroups=app.groups().getList();
        app.groups().createdGroup(group);
        var newGroups=app.groups().getList();
        var expectedList=new ArrayList<>(oldGroups);

        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));

        };
        newGroups.sort(compareById);
        expectedList.add(group.withId(newGroups.get(newGroups.size()-1).id()).withHeader("").withFooter(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups,expectedList);
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "group_name'", "", "")));
        return result;
    }
        @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreatedGroup(GroupData group) {
        //int groupCount=app.groups().getCount();
        var oldGroups=app.groups().getList();
        app.groups().createdGroup(group);
        //int newGroupCount=app.groups().getCount();
        var newGroups=app.groups().getList();
            Assertions.assertEquals(newGroups,oldGroups);

    }
}
