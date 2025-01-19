package at.codecrafters.learn_springboot_graphql.request;

import java.math.BigDecimal;

public class CreateSubjectRequest {

	private String subjectName;
	
	private BigDecimal marksObtained;

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
