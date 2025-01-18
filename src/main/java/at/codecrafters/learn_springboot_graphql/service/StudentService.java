package at.codecrafters.learn_springboot_graphql.service;

import java.util.ArrayList;
import java.util.List;

import at.codecrafters.learn_springboot_graphql.entity.Address;
import at.codecrafters.learn_springboot_graphql.entity.Student;
import at.codecrafters.learn_springboot_graphql.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.codecrafters.learn_springboot_graphql.repository.AddressRepository;
import at.codecrafters.learn_springboot_graphql.repository.StudentRepository;
import at.codecrafters.learn_springboot_graphql.repository.SubjectRepository;
import at.codecrafters.learn_springboot_graphql.request.CreateStudentRequest;
import at.codecrafters.learn_springboot_graphql.request.CreateSubjectRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public List<Student> getAllStudents () {
		return studentRepository.findAll();
	}
	
	public String getFirstNameById (long id) {
		return studentRepository.findById(id).get().getFirstName();
	}
	
	public String getLastNameById (long id) {
		return studentRepository.findById(id).get().getLastName();
	}
	
	public Student createStudent (CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);
		
		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());
		
		address = addressRepository.save(address);
		
		student.setAddress(address);
		student = studentRepository.save(student);
		
		List<Subject> subjectsList = new ArrayList<>();
		
		if(createStudentRequest.getSubjectsLearning() != null) {
			for (CreateSubjectRequest createSubjectRequest : 
					createStudentRequest.getSubjectsLearning()) {
				Subject subject = new Subject();
				subject.setSubjectName(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);
				
				subjectsList.add(subject);
			}
			
			subjectRepository.saveAll(subjectsList);
			
		}
		
		student.setLearningSubjects(subjectsList);
		
		return student;
	}
	
}
