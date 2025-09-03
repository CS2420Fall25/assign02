package assign02;

import java.util.ArrayList;

/**
 * This Java class represents a University of Utah student enrolled in CS 2420.
 * 
 * @author Donivan Schweiger and Ivy Bunnarith
 * @version September 3, 2025
 * @param <Type>
 */
public class CS2420StudentGeneric<Type> extends UofUStudent{
	Type contactInfo;
	ArrayList<Double> assignments, exams, labs, quizzes, polling ;
	
	/**
	 * Creates a student
	 * 
	 * @param firstName
	 * @param lastName
	 * @param uNID
	 * @param contactInfo
	 */
	public CS2420StudentGeneric(String firstName, String lastName, int uNID, Type contactInfo) {
		super(firstName, lastName, uNID);
		assignments = new ArrayList<Double>();
		exams = new ArrayList<Double>();
		labs = new ArrayList<Double>();
		quizzes = new ArrayList<Double>();
		polling = new ArrayList<Double>();
		this.contactInfo = contactInfo;
	}
	
	/**
	 * Retrieves the contact information of the student
	 * 
	 * @return contactInfo
	 */
	public Type getContactInfo(){
		return contactInfo;
	}	
	
	/**
	 * Adds a score to a student given a category of:
	 *  - "assignment"
	 *  - "exam"
	 *  - "lab"
	 *  - "quiz"
	 *  - "poll"
	 *  
	 * @param score	- the desired score
	 * @param category	- the desired category
	 */
	public void addScore(double score, String category) {
		switch (category) {
			case "assignment":
				assignments.add(score);
				break;
			case "exam":
				exams.add(score);
				break;	
			case "lab":
				labs.add(score);
				break;	
			case "quiz":
				quizzes.add(score);
				break;	
			case "poll":
				polling.add(score);
				break;	
		}
	}
	
	/**
	 * Computes the final score of a student based on the grade weights 
	 * within the CS2420 course syllabus
	 * 
	 * @return student total score
	 */
	public double computeFinalScore() {
		double totalScore = 0;
		if (checkEmpty()) return 0.0;
		totalScore += arrayCalculator(assignments, 0.3);
		totalScore += arrayCalculator(exams, 0.53);
		totalScore += arrayCalculator(labs, 0.07);
		totalScore += arrayCalculator(quizzes, 0.05);
		totalScore += arrayCalculator(polling, 0.05);
		return totalScore;
	}
	
	/**
	 * Calculates the average of a score category and weighs it with the given percentage
	 * 
	 * @param arr - the array to score
	 * @param perc - the percentage this category is worth
	 * @return the category array's score
	 */
	private double arrayCalculator(ArrayList<Double> arr, double perc) {
		double tempScore = 0;
		for (int i = 0; i < arr.size(); i++) 
			tempScore += arr.get(i);
		return (tempScore / arr.size()) * perc;
	}
	
	/**
	 * Checks if any of the score categories are empty
	 * 
	 * @return true if any category is empty
	 */
	private boolean checkEmpty () {
		return (assignments.isEmpty() || exams.isEmpty() || labs.isEmpty() || quizzes.isEmpty() || polling.isEmpty());
	}
	
	/**
	 * Computes the letter grade of the student based on the CS2420 course syllabus
	 * Runs computeFinalScore() and checks the score to a letter grade.
	 * 
	 * @return letter grade based on final score
	 */
	public String computeFinalGrade() {
		if (checkEmpty()) return "N/A";
		double totalScore = computeFinalScore();
		if (totalScore >= 93) return "A";
		if (totalScore >= 90) return "A-";
		if (totalScore >= 87) return "B+";
		if (totalScore >= 83) return "B";
		if (totalScore >= 80) return "B-";
		if (totalScore >= 77) return "C+";
		if (totalScore >= 73) return "C";
		if (totalScore >= 70) return "C-";
		if (totalScore >= 67) return "D+";
		if (totalScore >= 63) return "D";
		if (totalScore >= 60) return "D-";
		return "E";
	}
}