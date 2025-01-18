package at.codecrafters.learn_springboot_graphql.graphQLController;

import at.codecrafters.learn_springboot_graphql.config.GraphQLExceptionEx;
import at.codecrafters.learn_springboot_graphql.entity.Student;
import at.codecrafters.learn_springboot_graphql.response.StudentResponse;
import at.codecrafters.learn_springboot_graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class QueryMelangeController {

    @Autowired
    StudentService studentService;

    @QueryMapping
    public String firstQuery(){
        System.out.println("First query called");
        return "Hello World!";
    }
    //@QueryMapping, @SchemaMapping, und @MutationMapping

    @QueryMapping
    public String fullName(@Argument String fname, @Argument String lname){
        return fname + " " + lname;
    }

    @QueryMapping
    public String printHeld(@Argument HeldInput heldObj){
        return heldObj.name + " " + heldObj.age + " " + heldObj.friends.stream().map(fr -> fr.friendName).collect(Collectors.joining(", "));
    }

    record FriendRecord(String friendName){};
    record HeldInput(String name, Integer age, List<FriendRecord> friends){};

    @QueryMapping
    public StudentResponse student(@Argument("id") long id){
        Student student = studentService.getStudentById(id).orElse(null);
        if (student == null) {
            System.out.println("Student nicht gefunden, werfe Exception");
            throw new GraphQLExceptionEx("id " + id + " not found!", "Bad request");
        }
        return new StudentResponse(student);
    }


}
