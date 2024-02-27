package kr.s13.object.array;

public class Score {
	// 은닉화
	private String name;
	private int korean;
	private int english;
	private int math;

	// 생성자
	public Score(String n, int k, int e, int m) {
		name = n;
		korean = k;
		english = e;
		math = m;
	}

	// 총점 구하기
	public int getSum() {
		return korean + english + math;
	}

	// 평균 구하기
	public int getAvg() {
		return getSum() / 3;
	}

	// 등급 구하기
	public String getGrade() {
		String grade;
		switch (getAvg() / 10) {
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
	
	public String getName() {
		return name;
	}
	
	public int getKorean() {
		return korean;
	}
	
	public int getEnglish() {
		return english;
	}
	
	public int getMath() {
		return math;
	}
}
