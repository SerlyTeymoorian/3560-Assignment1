package student; 

import java.util.ArrayList;
import java.util.List;

import qa.MultipleChoiceQuestion;
import qa.Question;

public class Student implements StudentInformation {
	
	private String id;
	private ArrayList<String> studentAnswers = new ArrayList<String>(); 
	
	public Student(String id){
		this.id = "";
	}

	//set the student ID 
	//parameter: ID of student type String
	//nothing returned 
	@Override
	public void setStudentID(String id) {
		this.id = id; 
	}

	//get the student ID 
	@Override
	public String getStudentID() {
		return id;
	}

	//set the student answer or answers if question is multiple choice 
	@SuppressWarnings("unchecked")
	@Override
	public void setStudentAnswer(Question q, String... answer) {
		 
		ArrayList<String> answers = new ArrayList<String>(); 
		int counter = 0;
		
		for(String input: answer) {
			//IF THE QUESTION TYPE IS SingleChoice (not MultipleChoice) --> accept only one answer (1st one)
			if(!(q instanceof MultipleChoiceQuestion)) {
				answers.add(counter, input);
				break; 
			}
			//MAKE SURE THE STUDENT DOES NOT INPUT AN ANSWER TWICE 
			//BUT THE STUDENT CAN CHANGE ANSWER LATER 
			if(!answers.contains(input)) {
				answers.add(counter, input);
				++counter; 
			}
		}
		studentAnswers = (ArrayList<String>)answers.clone();
		
	}

	//get the student answer as list 
	//no parameter 
	@Override
	public List<String> getStudentAnswer() {
		return studentAnswers;
	}

}
