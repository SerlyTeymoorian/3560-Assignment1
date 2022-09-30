package qa;

import java.util.ArrayList;

public interface Question extends AnswerType {
	
	//set the answers to the question 
	public void setQuestionAnswer(String...answer);
	
	//get the answer 
	public ArrayList<String> getQuestionAnswer();
	
	//print the answer
	public void printTheAnswer(ArrayList<String> answers); 
	
	//set the question 
	public void setQuestion(String question);
	
	//print the question 
	public void printQuesitonWithAnswers(); 
	
	
}
