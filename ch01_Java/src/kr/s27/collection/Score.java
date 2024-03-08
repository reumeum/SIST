package kr.s27.collection;

public class Score {
	private String name;
	private int korean;
	private int english;
	private int math;

	// 총점 구하기 int makeSum()
	public int makeSum() {
		return korean + english + math;
	}

	// 평균 구하기 double makeAvg()
	public double makeAvg() {
		return makeSum() / 3.0;
	}

	// 등급 구하기 String makeGrade()
	public String makeGrade() {
		String grade;
		switch ((int) makeAvg() / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		
		return grade;
	}

	//get/set 메서드 정의
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

}
