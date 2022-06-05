import java.util.Scanner;

// 3행3열의 배열 두개를 선언하고 입력을 받아 두 배열의 합을 구하여 출력하는 프로그램 (입력받은 배열은 a,b로 정의하고 출력은 hap으로 정의해서 출력
public class ArrayPrac2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[][] a = new int[3][3];
		int[][] b = new int[3][3];
		int[][] hap = new int[3][3];
		
		for(int i=0; i<a.length; i++) {
			System.out.printf("첫 번쨰 배열 %d행 : ",i+1);
			for(int j=0; j<a.length; j++) {		//배열의 값을 가져오는게 아니고 입력만 할것이기 때문에 a[i] 안씀.
				a[i][j] = scanner.nextInt();
			}
		}
		
		for(int i=0; i<a.length; i++) {
			System.out.printf("두 번쨰 배열 %d행: ",i+1);
			for(int j=0; j<b.length; j++) {
				b[i][j] = scanner.nextInt();
			}
		}
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				hap[i][j] = a[i][j] + b[i][j];
				System.out.print(hap[i][j] + " ");
			}
			System.out.println();
		}

	}

}
