package DS07_201802170_하상호;
// AppController

public class AppController {
	//constant
	private static final int VALID_MAX_SCORE = 100;
	private static final int VALID_MIN_SCORE = 0;
	
	private static final int BAN_CAPACITY = 10;
	
	//입력한 점수가 범위를 벗어나지 않는지 확인
	private static boolean scoreIsValid(int aSocre) {
		return ( aSocre >= AppController.VALID_MIN_SCORE && 
				aSocre <= AppController.VALID_MAX_SCORE);
	}
	//점수 입력
	private static Student inputStudent() {
		int score = AppView.inputScore();
		while(! AppController.scoreIsValid(score)) {
			AppView.outputLine("[오류] " + 
			AppController.VALID_MIN_SCORE + " 보다 작거나 " + 
					AppController.VALID_MAX_SCORE + " 보다 커서, 정상적인 점수가 아닙니다.");
			score = AppView.inputScore();
		}
		Student student = new Student();
		student.setScore(score);
		return student;
	}
	// private instance variable
	private Ban _ban;
	private GradeCounter _gradeCounter;
	

	// Getters / Setters
	private Ban ban() {
		return this._ban;
	}
	private void setBan (Ban newBan) {
		this._ban = newBan;
	}
	private GradeCounter gradeCounter() {
		return this._gradeCounter;
	}
	private void setGradeCounter (GradeCounter newGradeCounter) {
		this._gradeCounter = newGradeCounter;
	}

	// constructor
	public AppController() {
	}

	// private method
	//점수를 ban 객체에 저장
	private void inputAndStroeStudent() {
		AppView.outputLine("");
		boolean storingAStudentWasSuccessful = true;
		while(storingAStudentWasSuccessful && AppView.doesContinueToInputStudent()) {
			Student student = AppController.inputStudent();
			if(! this.ban().add(student)) {
				AppView.outputLine("(경고) 입력에 오류가 있습니다. 학급에 더이상 학생을 넣을 공간이 없습니다.");
				storingAStudentWasSuccessful = false;
			}
		}
		AppView.outputLine("! 성적 입력을 마칩니다.");
	}
	//성적 통계 출력
	//학생수 , 최고 점수, 최저 점수, 평균 점수. 평균이상인 학생수
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("[학급 성적 통계]");
		
		AppView.outputNumberOfStudents(this.ban().size());
		AppView.outputHighestScore(this.ban().highest().score());
		AppView.outputLowestScore(this.ban().lowest().score());
		AppView.outputAverageScore(this.ban().average());
		AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());
	}
	//학점별 학생수 출력
	private void showGradeCounts() {
		AppView.outputLine("");
		AppView.outputLine("[학점별 학생수]");
		
		this.setGradeCounter(this.ban().countGrades());
		AppView.outputNumberOfStudentsForGrade('A', this.gradeCounter().numberOfA());
		AppView.outputNumberOfStudentsForGrade('B', this.gradeCounter().numberOfB());
		AppView.outputNumberOfStudentsForGrade('C', this.gradeCounter().numberOfC());
		AppView.outputNumberOfStudentsForGrade('D', this.gradeCounter().numberOfD());
		AppView.outputNumberOfStudentsForGrade('F', this.gradeCounter().numberOfF());
	}
	//성적순 목록 출력
	private void showStudentsSortedByScore() {
		AppView.outputLine("");
		AppView.outputLine("[학생들의 성적순 목록]");
		
		this.ban().sortByScore();
		
		Iterator<Student> iterator = this.ban().iterator();
		Student student = null;
		while (iterator.hasNext()) {
			student = iterator.next();
			AppView.outputScore(student.score());
		}
	}
	
	
	// public method
	public void run() {
		AppView.outputLine("");
		AppView.outputLine("<<<학급 성적 처리를 시작합니다 >>>");
		
		this.setBan(new Ban(AppController.BAN_CAPACITY));
		this.inputAndStroeStudent();
		if(this.ban().isEmpty()) {
			AppView.outputLine("");
			AppView.outputLine("(경고) 입력된 성적이 없습니다.");
		}
		else {
			this.showStatistics();
			this.showGradeCounts();
			this.showStudentsSortedByScore();
		}
		AppView.outputLine("");
		AppView.outputLine("<<< 학급 성적 처리를 종료합니다. >>>");
	
	}

}// End of class "AppController"
