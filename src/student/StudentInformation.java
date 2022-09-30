package student;

import java.util.List;

import qa.Question;

public interface StudentInformation {
	
	public void setStudentID(String id);
	public String getStudentID();
	public void setStudentAnswer(Question q, String... answer);
	public List<String> getStudentAnswer();
}
