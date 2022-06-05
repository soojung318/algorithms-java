package review_04_17;

public class Student {
	private int korScore;
	private int engScore;
	private int mathScore;
	
	// 객체 생성시 필드 초기화
	public Student(int korScore, int engScore, int mathScore){
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	public int getSum() {
		return korScore + engScore + mathScore;
	}
	
	public int getAvg() {
		return getSum()/3;
	}
	
	public int getKorScore() {
		return korScore;
	}


	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}


	public int getEngScore() {
		return engScore;
	}


	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}


	public int getMathScore() {
		return mathScore;
	}


	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}


	
	
	public static void main(String[] args) {
		
		Student[] students = new Student[10];
		
		students[0] = new Student(100,70,80);
		students[1] = new Student(70,80,60);
		students[2] = new Student(80,70,70);
		students[3] = new Student(60,80,80);
		students[4] = new Student(50,60,70);
		students[5] = new Student(70,50,60);
		students[6] = new Student(90,90,50);
		students[7] = new Student(90,80,90);
		students[8] = new Student(80,70,90);
		students[9] = new Student(100,80,90);
		
		System.out.println("###Score Report###");
		System.out.println("국어\t 영어\t 수학\t \\\t 총합\t 평균\t");
		System.out.println("-------------------------------------------------");
		
		for(int i=0; i<10; i++) {
			System.out.printf("%d \t %d \t %d \t\t %d \t %d \n",
			students[i].getKorScore(),
			students[i].getEngScore(),
			students[i].getMathScore(),
			students[i].getSum(),
			students[i].getAvg());
		}
	
	}

}
