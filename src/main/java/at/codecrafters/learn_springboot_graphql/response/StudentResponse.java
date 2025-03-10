package at.codecrafters.learn_springboot_graphql.response;

import java.util.List;
import at.codecrafters.learn_springboot_graphql.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("ALL")
public class StudentResponse {

	private long id;

	@JsonProperty("first_name")
	private String firstName;

	private String lastName;

	private String fullName;

	private String email;
	
	private String street;

	private String city;
	
	private List<SubjectResponse> learningSubjects;

	private Student internal_use_student;
	
	public StudentResponse (Student student) {
		internal_use_student= student;
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
		
//		if (student.getLearningSubjects() != null) {
//			learningSubjects = new ArrayList<SubjectResponse>();
//			for (Subject subject: student.getLearningSubjects()) {
//				learningSubjects.add(new SubjectResponse(subject));
//			}
//		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<SubjectResponse> getLearningSubjects() {
		return learningSubjects;
	}

	public void setLearningSubjects(List<SubjectResponse> learningSubjects) {
		this.learningSubjects = learningSubjects;
	}

	public Student getInternal_use_student() {
		return internal_use_student;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
