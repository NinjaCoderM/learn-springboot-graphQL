package at.codecrafters.learn_springboot_graphql.resolver;

import at.codecrafters.learn_springboot_graphql.enums.SubjectNameFilter;
import at.codecrafters.learn_springboot_graphql.response.StudentResponse;
import at.codecrafters.learn_springboot_graphql.response.SubjectResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import at.codecrafters.learn_springboot_graphql.entity.Subject;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentResponseResolver{
    @SchemaMapping(typeName = "StudentResponse", field="learningSubjects")
    List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse, @Argument SubjectNameFilter subjectNameFilter){
        List<SubjectResponse> learningSubjects = new ArrayList<>();
        if (studentResponse.getInternal_use_student().getLearningSubjects() != null) {
			for (Subject subject: studentResponse.getInternal_use_student().getLearningSubjects()) {
                if(subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())||subjectNameFilter.name().equalsIgnoreCase("ALL")) {
                    learningSubjects.add(new SubjectResponse(subject));
                }
			}
		}
        return learningSubjects;
    }
    @SchemaMapping(typeName = "StudentResponse", field="fullName")
    String getFullName(StudentResponse studentResponse){
        String fullName = "";
        if (studentResponse.getFirstName() != null) {
            fullName = studentResponse.getFirstName();
        }
        if (studentResponse.getLastName() != null) {
            fullName += (fullName.isEmpty()?"":" ") + studentResponse.getLastName();
        }
        return fullName;
    }
}
