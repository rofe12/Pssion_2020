package DS13_201802170_하상호;
public class Student implements Comparable<Student> {
	private static final int DEFAULT_SCORE = 0; // 상수

	private int _score; // 인스턴스 변수
	private String _id;

	public int score() { // getter
		return this._score;
	}

	public void setScore(int newScore) { // setter
		this._score = newScore;
	}
	
	public String id(){
		return this._id;
	}
	
	public void setId(String newId) {
		this._id = newId;
	}

	public Student() { // 학생의 점수를 DEFAULT_SCORE로 초기화하여 객체 생성
		this.setScore(DEFAULT_SCORE);
		this.setId(null);
	}

	public Student(int givenScore, String givenId) { // 학생의 점수를 givenScore로 초기화하여 객체 생성
		this.setScore(givenScore);
		this.setId(givenId);
	}

	@Override
	public int compareTo(Student other) {
		if (this.score() < other.score()) { // other값이 더 크면 -1 
			return -1;
		} else if (this.score() == other.score()) { // other값과 같으면 0
			return 0;
		} else { // other값이 더 작으면 1
			return +1;
		}
	}
	
	public char Grade() {
		if (this.score() >= 90) {
			return 'A';
		} else if (this.score() >= 80) {
			return 'B';
		} else if (this.score() >= 70) {
			return 'C';
		} else if (this.score() >= 60) {
			return 'D';
		} else
			return 'F';
	}// 주어진 aScore 에 해당하는 학점을 얻는다.



}
