package at.codecrafters.learn_springboot_graphql.mutation;

import at.codecrafters.learn_springboot_graphql.request.CreateStudentRequest;
import at.codecrafters.learn_springboot_graphql.response.StudentResponse;
import at.codecrafters.learn_springboot_graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class Mutation {

    @Autowired
    private StudentService studentService;

    @MutationMapping
    @Transactional
    public StudentResponse createStudent(@Argument CreateStudentRequest createStudentRequest) {
        return new StudentResponse(studentService.createStudent(createStudentRequest));
    }
}
