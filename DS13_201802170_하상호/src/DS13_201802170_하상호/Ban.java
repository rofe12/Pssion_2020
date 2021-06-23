package DS13_201802170_하상호;

//Ban class
public class Ban extends DictionaryByBinarySearchTree<String, Student> {


	// Constructor
	public Ban() {
		super();
	}

	// Public Instance methods /private Instance methods
	// 최솟값을 받는 methods
	private DictionaryElement<String, Student> lowestRecursively(BinaryNode<DictionaryElement<String, Student>> aRoot) {
		DictionaryElement<String, Student> lowest = aRoot.element();
		if (aRoot.left() != null) {
			DictionaryElement<String, Student> lowestOfLeftSubtree = this.lowestRecursively(aRoot.left());
			if (lowestOfLeftSubtree.object().score() < lowest.object().score()) {
				lowest = lowestOfLeftSubtree;
			}
		}
		if (aRoot.right() != null) {
			DictionaryElement<String, Student> lowestOfRightSubtree = this.lowestRecursively(aRoot.right());
			if (lowestOfRightSubtree.object().score() < lowest.object().score()) {
				lowest = lowestOfRightSubtree;
			}
		}
		return lowest;
	}

	public Student lowest() {
		if (this.isEmpty()) {
			return null;
		} else {
			DictionaryElement<String, Student> lowest = this.lowestRecursively(this.root());
			return lowest.object();
		}
	}

	// 최대값을 받는 methods
	private DictionaryElement<String, Student> highestRecursively(
			BinaryNode<DictionaryElement<String, Student>> aRoot) {
		DictionaryElement<String, Student> highest = aRoot.element();
		if (aRoot.left() != null) {
			DictionaryElement<String, Student> highestOfLeftSubtree = this.highestRecursively(aRoot.left());
			if (highestOfLeftSubtree.object().score() > highest.object().score()) {
				highest = highestOfLeftSubtree;
			}
		}
		if (aRoot.right() != null) {
			DictionaryElement<String, Student> highestOfRightSubtree = this.highestRecursively(aRoot.right());
			if (highestOfRightSubtree.object().score() > highest.object().score()) {
				highest = highestOfRightSubtree;
			}
		}

		return highest;
	}

	public Student highest() {
		if (this.isEmpty()) {
			return null;
		} else {
			DictionaryElement<String, Student> highest = this.highestRecursively(this.root());
			return highest.object();
		}
	}

	// 성적의 합계
	private int sumOfScores() {
		return this.sumOfScoresRecursively(this.root());
	}

	// 성적의 합계를 반환하는 private method
	private int sumOfScoresRecursively(BinaryNode<DictionaryElement<String, Student>> aRoot) {
		int sum = 0;
		if (aRoot.left() != null) {
			int leftSum = sumOfScoresRecursively(aRoot.left());
			sum += leftSum;
		} else if (aRoot.right() != null) {
			int rightSum = sumOfScoresRecursively(aRoot.right());
			sum += rightSum;
		}
		sum += aRoot.element().object().score();
		return sum;
	}

	// 평균값을 반환
	public double average() {
		if (this.isEmpty())
			return 0;
		else
			return (((double) this.sumOfScores()) / ((double) this.size()));
	}

	// 평균보다 큰 학생수를 반환
	public int numberOfStudentsAboveAverage() {
		double average = this.average();
		int numberOfStudentsAboveAverage = 0;
		Iterator<DictionaryElement<String, Student>> iterator = this.iterator();
		while (iterator.hasNext()) {
			DictionaryElement<String, Student> student = iterator.next();
			if (student.object().score() >= average) {
				numberOfStudentsAboveAverage++;
			}
		}
		return numberOfStudentsAboveAverage;
	}

	public GradeCounter countGrades() {
		char grade;
		GradeCounter gradeCounter = new GradeCounter();
		Iterator<DictionaryElement<String, Student>> iterator = this.iterator();
		while (iterator.hasNext()) {
			grade = iterator.next().object().Grade();
			gradeCounter.count(grade);
		}
		return gradeCounter;
	}

	public Student[] studentsSortedByScore() {
		@SuppressWarnings("unchecked") // Why?
		Student[] students = new Student[this.size()];
		Iterator<DictionaryElement<String, Student>> iterator = this.iterator();
		for (int i = 0;  iterator.hasNext(); i++) {
			students[i] = iterator.next().object();
		}
		Sort<Student> quicksort = new QuickSort<Student>();
		quicksort.sort(students, students.length);
		return students;
	}
	
	public static char scoreToGrade(int aScore) {
		if (aScore >= 90) {
			return 'A';
		} else if (aScore >= 80) {
			return 'B';
		} else if (aScore >= 70) {
			return 'C';
		} else if (aScore >= 60) {
			return 'D';
		} else {
			return 'F';
		}
	}
}
