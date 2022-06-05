package Textbook_HonGongJa;

public class AdvacedForExample {

	public static void main(String[] args) {
		// p.198 축약 for문
		
		int[] scores = { 95, 71, 84, 93, 87 };
		
		int sum = 0;
		
		for(int score : scores) {	//scores의 값을 score에 순차적으로 저장
			sum = sum + score;
		}
		System.out.println("점수 총합=" + sum);
		
		double avg = (double) sum/ scores.length;
		System.out.println("점수 평균 = " + avg);

	}

}
