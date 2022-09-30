package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import qa.MultipleChoiceQuestion;
import qa.Question;
import qa.SingleChoiceQuestion;
import student.Student;
import votingService.VotingService;
import votingService.iVote;

public class SimulatorDriver {

	public static void main(String[] args) {
		
//*********************************************************************************************//
//							Create Question Type and Configure the Answers 
//*********************************************************************************************//
		
		//choose a question type: multiple choice 
		Question question = new MultipleChoiceQuestion();
	
		//configure the answers 
		//so the answers could be among: A, B, C, D, E
		question.setAnswerTypes("A", "B" , "C" , "D", "E");
		
		//set the question's answer 
		// ----> A and C 
		 question.setQuestionAnswer("A","C"); 
		 
		 //set the question and answer choices 
		 question.setQuestion("What is the capital of Canada?\nA) Toronto\nB) Ottawa\nC) Vancouver\nD) Montreal");
		
		 //print the question and answer choices so students can pick from 
		 question.printQuesitonWithAnswers(); 
		 
//*********************************************************************************************//
//					Randomly Generate a Number Students and the Answers
//*********************************************************************************************// 
		 
		//creating 50 students 
		Student[] students = new Student[50];
		iVote votes = new VotingService(question); 
		//creating 50 random UNIQUE STUDENT IDs 
		List<Integer> randomUniqueIds = nonRepeatingRandom(50); 
		
		//set the random unique ID numbers and answers to each student
	    for(int counter = 0; counter < 50; ++counter) { 
	    	students[counter] = new Student(" "); 
	    	//set the student ID 
			students[counter].setStudentID(randomUniqueIds.get(counter).toString());
			
			//set the student answer randomly 
			//half students have single answer for the question and the other half put two answers 
			if(counter % 2 == 0) {
				 students[counter].setStudentAnswer(question, question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size())))); 
			} else {
				 students[counter].setStudentAnswer(question, question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size()))), question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size())))); 
			}
			votes.saveStudentAnswers(students[counter]);
		} 

//*********************************************************************************************//
//						Submit All the Students’ Answers to iVote Service
//*********************************************************************************************// 	
	   
	    //create a voting service 
	    //pass in the question to it 
	    
	    
//	    //pass in students' answers 
//	    for(int index = 0; index < students.length; ++index) {
//	    	votes.saveStudentAnswers(students[index]); 
//	    }
	    
	    // 5 STUDENTS CHANGE THEIR VOTES AND RESUBMIT TO iVote 
	    students[3].setStudentAnswer(question, question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size()))), question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size()))));
	    students[13].setStudentAnswer(question, question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size()))), question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size()))));
	    students[16].setStudentAnswer(question, question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size()))));
	    students[20].setStudentAnswer(question, question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size()))));
	    students[25].setStudentAnswer(question, question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size()))), question.getAnswerTypes().get((int)(Math.random() * (question.getAnswerTypes().size()))));
	    
	    //save the results again in iVote
	    votes.saveStudentAnswers(students[3]);
	    votes.saveStudentAnswers(students[13]);
	    votes.saveStudentAnswers(students[16]);
	    votes.saveStudentAnswers(students[20]);
	    votes.saveStudentAnswers(students[25]);
	    
	    
//*********************************************************************************************//
//		 		Call the Voting Service Output Function to Display the Result
//*********************************************************************************************// 		    
	   
	    //print out the number of students voted 
	    System.out.println(students.length + " students have submit their answers to iVote system!!\n");
	    
	    //DISPLAY THE RESULT 
	    votes.displayResults();
	    
	    //print the correct answer(s)
	    question.printTheAnswer(question.getQuestionAnswer()); 
	    
	}

//*********************************************************************************************//
//									Helper Function
//*********************************************************************************************// 	
	
	//Create random non repeating number 
	//parameter: size of type integer for number of non repeating random numbers to be created and the range 
	//return an ArrayList of type Integer of the non-repeating random numbers 
	private static ArrayList<Integer> nonRepeatingRandom(int size){
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		Random rand = new Random();
		
		while(nums.size() < size) {
			int randomNum = rand.nextInt(size + 1);
			if(!nums.contains(randomNum)) {
				nums.add(randomNum); 
			}
		}
		return nums; 
	}
}
