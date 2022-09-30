package qa;

import java.util.ArrayList;

public interface AnswerType {
	
	//answer types of the question 
	public void setAnswerTypes(String... string);
	
	//get the answer types 
	public ArrayList<String> getAnswerTypes();
}
