package at.codecrafters.learn_springboot_graphql.response;

import at.codecrafters.learn_springboot_graphql.entity.Subject;

import java.math.BigDecimal;

public class SubjectResponse {

	private Long id;
	
	private String subjectName;

	private BigDecimal marksObtained;
	
	public SubjectResponse (Subject subject) {
		this.id = subject.getId();
		this.subjectName = subject.getSubjectName();
		this.marksObtained = subject!=null?BigDecimal.valueOf(subject.getMarksObtained()):null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public BigDecimal getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(BigDecimal marksObtained) {
		this.marksObtained = marksObtained;
	}
}
