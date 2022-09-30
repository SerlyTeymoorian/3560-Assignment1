package qa;

import java.util.ArrayList;

public class SingleChoiceQuestion extends AnswerTypes implements Question {

	private ArrayList<String> answers = new ArrayList<String>(); 
	private String question; 
	
	//only one answer is accepted 
	//parameter: one correct answer 
	//nothing returned 
	@Override
	public void setQuestionAnswer(String... answer) {
		int counter = 0; 
		
		for(String theAnswer: answer) {
			//make sure that the argument is only one and that it is one of the answer choices 
			if(counter == 0 && getAnswerTypes().contains(theAnswer)) {
				answers.add(counter, theAnswer);
			} else {
				throw new IllegalArgumentException("ONLY ONE ANSWER CAN BE ACCEPTED!!"); 
			}
		}
	}

	//get the question's correct answers 
	//no parameter
	//the ArrayList of correct questions returned 
	@Override
	public ArrayList<String> getQuestionAnswer() { return answers; }

	//set the question with its answer choices 
	//parameter: question with its answer choices type of String 
	//nothing returned 
	@Override
	public void setQuestion(String question) { this.question = question; }

	//print the question and its answer choices 
	//no parameter 
	//nothing returned 
	@Override
	public void printQuesitonWithAnswers() { System.out.println(question + "\n\n"); }
	
	//printing the correct answer or answers to the question 
	//no input provided and nothing returned 
	@Override
	public void printTheAnswer(ArrayList<String> answers) { 
		System.out.println("The correct answer to the question: ");
		for(int index = 0; index < answers.size(); ++index) {
			System.out.print(answers.get(index) + " ");
		}
	}
}
