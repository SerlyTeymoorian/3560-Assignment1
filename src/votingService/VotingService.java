package votingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qa.Question;
import student.Student;

public class VotingService  implements iVote {
	
	private Map<String, List<String>> studentsAnswers = new HashMap<String, List<String>>(); 
	
	private Map<String, Integer> numberOfAnswers = new HashMap<String, Integer>();
	
	//Constructor with argument which is a Question object 
	public VotingService(Question answerTypes) {
		//initialize 
		for(int counter = 0; counter < answerTypes.getAnswerTypes().size(); ++counter) {
			numberOfAnswers.put(answerTypes.getAnswerTypes().get(counter), 0);
		}
	}
	
	//SAVE THE LATEST VOTE OF EACH STUDENT 
	//IF THEY HAVE VOTED BEFORE, CLEAR THE RESULT OF THEIR VOTE AND RESUBMIT A NEW VOTE WITH NEW ANSWER(S)
	@Override 
	public void saveStudentAnswers(Student student) {
		
		//the student already submitted vote 
		//override it 
		if(studentsAnswers.containsKey(student.getStudentID())) {
			//clear their previous vote 
			clearAnswers(student);
			
			//save the current answer in the studetsAnswers 
			studentsAnswers.replace(student.getStudentID(), student.getStudentAnswer());
			
			//update the number of votes for that particular answer choice 
			updateAnswers(student);
			
		} else {
			//save the current answer in the studetsAnswers 
			studentsAnswers.put(student.getStudentID(), student.getStudentAnswer());
			
			//update the number of votes for that particular answer choice 
			updateAnswers(student);
		}
	}
	
	//print out the result --> number of votes for each answer type 
	//no parameter or return type 
	public void displayResults() {
			
		System.out.println("The Result for Each Answers Type is Shown Below: "); 
			
		for(Map.Entry<String, Integer> answerType: numberOfAnswers.entrySet()) {
			System.out.print(answerType.getKey() + ": " + answerType.getValue() + "	 ");
		}
		System.out.println("\n"); 
	}
//****************************************************************************//
//				Helper Functions 
//****************************************************************************//
		
	//update the number of votes for a particular answer type
	//parameter: student of type of Student 
	//nothing returned 
	private void updateAnswers(Student s) {
		
		for(int index = 0; index < studentsAnswers.get(s.getStudentID()).size(); ++index) {
			
			//update the # of answers for that answer choice 
			numberOfAnswers.put(studentsAnswers.get(s.getStudentID()).get(index), numberOfAnswers.get(studentsAnswers.get(s.getStudentID()).get(index)) + 1);
		}
	}

	//decrease the number of votes for a previously voted answer choice if a new vote is submitted by the student 
	//parameter: student of type of Student 
	//nothing returned 
	private void clearAnswers(Student s) {
		
		for(int index = 0; index < studentsAnswers.get(s.getStudentID()).size(); ++index) {
			//decrease the number of votes for the previous answered question 
			numberOfAnswers.replace(studentsAnswers.get(s.getStudentID()).get(index),numberOfAnswers.get(studentsAnswers.get(s.getStudentID()).get(index)) - 1);
		}
	}
}
