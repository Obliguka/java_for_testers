package ru.stqa.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator {

    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-o"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-c"})
    int count;

    public static void main(String[] args) throws IOException {
        var generator= new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);

        generator.run();
    }

    private void run() throws IOException {
        var data=generate();
        save(data);
    }

    private void save(Object data) throws IOException {
        if("json".equals(format))
        {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        //mapper.writeValue(new File(output), data);
         var json=mapper.writeValueAsString(data);

         try (var writer = new FileWriter(output)) {
            writer.write(json);
        }}else if ("yaml".equals(format)){
             var mapper1=new YAMLMapper();
             mapper1.writeValue(new File(output),data);
        }else if ("xml".equals(format)){
        var mapper1=new XmlMapper();
        mapper1.writeValue(new File(output),data);
         }
         else {
            throw new IllegalArgumentException("Неизвестный формат данных "+format);
        }
    }




    private Object generate(){
        if ("groups".equals(type)){
            return generateGroups();
        }else if ("contacts".equals(type)){
            return generateContacts();
        }else{
            throw new IllegalArgumentException("Неизвестный тип днных "+type);
        }

    }

    private Object generateData(Supplier<Object> dataSupplier){
        return Stream.generate(dataSupplier).limit(count).collect(Collectors.toList());
    }


    private Object generateGroups() {
        return generateData(()-> new GroupData().
                withName(CommonFunctions.randomString(10)).
                withHeader(CommonFunctions.randomString(10)).
                withFooter(CommonFunctions.randomString(10)));
       /* var result=new ArrayList<GroupData>();
        for(int i=0;i<count;i++)
        {
            result.add(new GroupData().
                    withName(CommonFunctions.randomString(i*10)).
                    withHeader(CommonFunctions.randomString(i*10)).
                    withFooter(CommonFunctions.randomString(i*10)));
        }
        return result;*/
    }

   /* private Object generateContacts() {
        var result=new ArrayList<ContactData>();
        for(int i=0;i<count;i++)
        {
          result.add(new ContactData().
                withFirstName(CommonFunctions.randomString(10)).
                withLastName(CommonFunctions.randomString(10)).
                withAddress(CommonFunctions.randomString(10)));
        }

        return result;
    }*/

    private Object generateContacts() {
        return generateData(()->new ContactData().
                withFirstName(CommonFunctions.randomString(10)).
                withLastName(CommonFunctions.randomString(10)).
                withAddress(CommonFunctions.randomString(10)));

    }
}
