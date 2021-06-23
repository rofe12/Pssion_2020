package DS07_201802170_«œªÛ»£;
 //Student class
public class Student implements Comparable<Student> {
	// Constants
	private static final int DEFAULT_SCORE = 0;

	// Private Instance Variables
	private int _score;

	// Getters/Setters
	public int score() {
		return this._score;
	}

	public void setScore(int newScore) {
		this._score = newScore;
	}

	// Constructor
	public Student() {
		this.setScore(Student.DEFAULT_SCORE);
	}

	public Student(int givenScore) {
		this.setScore(givenScore);
	}


	@Override
	public int compareTo(Student other) {
		// TODO Auto-generated method stub
		if(this.score() < other.score()) {
			return -1;
		}
		else if(this.score() == other.score()) {
			return 0;
		}
		else return +1;
	}

}//end of Student
