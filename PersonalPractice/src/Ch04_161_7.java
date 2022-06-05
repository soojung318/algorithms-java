import java.util.Scanner;

public class Ch04_161_7 {

	public static void main(String[] args) {
		int balance = 0;
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("--------------------------------");
			System.out.print("선택> ");
			int x = scanner.nextInt();
			
			switch(x) {
			case 1:
				System.out.println("예금액>10000");
				x = scanner.nextInt();
				break;
			case 2:
				System.out.println("출금액>2000");
				x = scanner.nextInt();
				break;
			case 3:
				System.out.println("잔고>8000");
				x = scanner.nextInt();
				break;
			case 4:
				run = false;
				break;
			}
			System.out.println();
		}
		System.out.println("프로그램 종료");
	}

}
