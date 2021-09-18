package lLambda;

public class Lambda_University {
	
	// Encapsulation
	
	private String faculty;
	private String department;
	private int score;
	private int studentNo;
	
	public Lambda_University(String faculty, String department, int score, int studentNo) {
		
		this.faculty = faculty;
		this.department = department;
		this.score = score;
		this.studentNo = studentNo;
	}

	public String getFaculty() {
		return faculty;
	}

	public String getDepartment() {
		return department;
	}

	public int getScore() {
		return score;
	}

	public int getStudentNo() {
		return studentNo;
	}

	@Override
	public String toString() {
		return "Lambda_University_6 [faculty=" + faculty + ", department=" + department + ", score=" + score
				+ ", studentNo=" + studentNo + "]";
	}
	
	

}