package qa;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends SingleChoiceQuestion implements Question {

	private ArrayList<String> answers = new ArrayList<String>(); 
	
	//override the function to let multiple answers 
	//parameter: set of answers or one answer
	//nothing returned
	@Override
	public void setQuestionAnswer(String... answer) {
		
		int counter = 0;
		
		for(String theAnswer: answer)
		{
			//check if the input answer matches to any of the Answer Types 
			if(getAnswerTypes().contains(theAnswer)) {
				answers.add(counter, theAnswer);
			} else {
				throw new IllegalArgumentException("Invalid Argument Entered!!"); 
			}
			++counter;
		}
	}
	
	@Override
	public ArrayList<String> getQuestionAnswer() { return answers; }
}
