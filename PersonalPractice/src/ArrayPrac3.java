import java.util.Scanner;

//학생 3명의 국어, 영어, 수학 점수를 입력받아 학생별 총점과 과목별 합계를 아래와 같이 출력하는 프로그램 (정수 찍을 때는 %4d로 하고 배열은 1개만 선언해서 사용) 

public class ArrayPrac3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[][] a = new int[4][4];
		
		for(int i=0; i<a.length-1; i++) {
			System.out.printf("%d번쨰 학생의 점수: ",i+1);
			
			for(int j=0; j<a[i].length-1; j++) {
				a[i][j] = scanner.nextInt();
				a[i][a[a.length-1].length-1] += a[i][j];
				a[a.length-1][j] += a[i][j];
				a[a.length-1][a[a.length-1].length-1] += a[i][j];
			}
		}
		System.out.println("\t 국어\t 영어\t 수학\t 총점");
		for(int i=0; i<a.length; i++) {
			if(i<a.length-1) {
				System.out.printf("%d번\t", i+1);
			}else {
				System.out.print("합계\t");
			}
			for(int j=0; j<a.length; j++) {
				System.out.printf("%4d\t", a[i][j]);
			}
			System.out.println();
		}

	}

}
