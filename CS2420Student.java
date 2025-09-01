package assign02;

import java.util.ArrayList;

public class CS2420Student extends UofUStudent{
	EmailAddress contactInfo;
	ArrayList<Double> assignments, exams, labs, quizzes, polling ;
	
	public CS2420Student(String firstName, String lastName, int uNID, EmailAddress contactInfo) {
		super(firstName,lastName,uNID);
		assignments = new ArrayList<Double>();
		exams = new ArrayList<Double>();
		labs = new ArrayList<Double>();
		quizzes = new ArrayList<Double>();
		polling = new ArrayList<Double>();
	}
	
	public EmailAddress getContactInfo(){
		return contactInfo;
	}	
	
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
	
	private double arrayCalculator(ArrayList<Double> arr, double perc) {
		double tempScore = 0;
		for (int i = 0; i < arr.size(); i++) { 
			tempScore += arr.get(i);
		}
		return (tempScore / arr.size()) * perc;
	}
	
	private boolean checkEmpty () {
		return (assignments.isEmpty() || exams.isEmpty() || labs.isEmpty() || quizzes.isEmpty() || polling.isEmpty());
	}
	
	public String computeFinalGrade() {
		if (checkEmpty()) return "N/A";
		double totalScore = computeFinalScore();
		if (totalScore > 93) return "A";
		if (totalScore > 90) return "A-";
		if (totalScore > 87) return "B+";
		if (totalScore > 83) return "B";
		if (totalScore > 80) return "B-";
		if (totalScore > 77) return "C+";
		if (totalScore > 73) return "C";
		if (totalScore > 70) return "C-";
		if (totalScore > 67) return "D+";
		if (totalScore > 63) return "D";
		if (totalScore > 60) return "D-";
		return "E";
	}
}