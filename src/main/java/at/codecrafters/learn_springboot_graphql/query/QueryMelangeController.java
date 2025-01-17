package at.codecrafters.learn_springboot_graphql.query;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class QueryMelangeController {

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




}
