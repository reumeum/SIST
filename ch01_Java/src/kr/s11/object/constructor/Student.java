package kr.s11.object.constructor;

public class Student {
	int korean;
	int english;
	int math;
	int history;
	int science;
	int num;    // 과목수

	// 생성자 오버로딩
	public Student(int k, int e, int m) {
		korean = k;
		english = e;
		math = m;
		num = 3;
	}

	public Student(int k, int e, int m, int h, int s) {
		korean = k;
		english = e;
		math = m;
		history = h;
		science = s;
		num = 5;
	}

	// 총점 구하기
	public int getTotal() {
		int total;
		if (num == 3) { // 3과목 시험
			total = korean + english + math;
		} else { // 5과목 시험
			total = korean + english + math + history + science;
		}
		return total;
	}

	// 평균 구하기
	public int getAverage() {
		return getTotal() / num;
	}

	public static void main(String[] args) {
		// 3r과목 시험보기
		Student s1 = new Student(80, 97, 95);

		System.out.println("합계 = " + s1.getTotal());
		System.out.println("평균 = " + s1.getAverage());
		System.out.println("-------------------------");

		Student s2 = new Student(88, 82, 84, 87, 90);
		System.out.println("합계 = " + s2.getTotal());
		System.out.println("평균 = " + s2.getAverage());

	}

}
