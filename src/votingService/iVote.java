package votingService;

import student.Student;

public interface iVote {
	
	//display the results 
	public void displayResults();

	//save the students' answers 
	public void saveStudentAnswers(Student student);
}
