package qa;

import java.util.ArrayList;

public class AnswerTypes implements AnswerType {
	
	//the String of answer types created by the user 
	private ArrayList<String> returnAnswerType = new ArrayList<String>();
	
	//configure answer types of the question 
	//set of answer types of type String
	//nothing returned 
	@Override
	public void setAnswerTypes(String... string) {
		int counter = 0; 
		
		for(String input: string) {
			returnAnswerType.add(counter, input);
			++counter; 
		}
	}

	//return the answer types 
	//no parameter 
	@Override
	public ArrayList<String> getAnswerTypes() {
		return returnAnswerType;
	}

}
