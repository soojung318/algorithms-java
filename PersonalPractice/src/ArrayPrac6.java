import java.util.Scanner;

//String 2차원 배열을 이용한 단어맞추기 게임 - 영어단어의 뜻을 입력하여 정답이면 정답입니다. 오답이면 틀렸습니다. 정답은 ~입니다 라고 출력하는 프로그램

public class ArrayPrac6 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); 
		String[][] a = new String[][]{{"Chair", "의자"},{"Computer", "컴퓨터"},{"Integer", "정수"}}; 
		int i; 
		
		for( i=0; i<a.length; i++) { 
			System.out.printf("Q%d. %s의 뜻은? ", i+1, a[i][0]); 
			if(a[i][1].equals(scn.next())) { 
				System.out.println("정답입니다.\n"); 
				} else { System.out.printf("틀렸습니다.\n정답은 %s입니다.\n\n", a[i][1]);
				} 
			}


	}

}
