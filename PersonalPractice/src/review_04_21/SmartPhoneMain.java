package review_04_21;

import java.util.Scanner;

public class SmartPhoneMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		SmartPhone smartPhone = new SmartPhone();
		
		System.out.println("# 데이터 2개를 입력합니다.");
		for(int i=0; i<2; i++) {
			smartPhone.addContact(smartPhone.inputContactData());
		}
		boolean run = true;
		while(run) {
			
			printMenu();
			int num = scanner.nextInt();
		
			switch(num) {
			case 1:
				smartPhone.addContact(smartPhone.inputContactData());
				break;
			case 2:
				smartPhone.printAllContact();
				break;
			case 3:
				System.out.print("검색하고자 하는 이름을 입력해주세요.>>");
				smartPhone.searchContact();
				break;
			case 4:
				System.out.print("삭제하고자 하는 이름을 입력해주세요.>>");
				smartPhone.deleteContact();
				break;
			case 5:
				String name = scanner.nextLine();
				System.out.print("수정하고자 하는 이름을 입력해주세요.>>");
				smartPhone.searchContact();
				System.out.println("데이터를 새로 입력해주세요.");
				smartPhone.editContact(name,smartPhone.inputContactData());
				break;
			case 6:
				run = false;
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
		}
	}

	static void printMenu(){
		System.out.println("Contact-----------------------------------");
		System.out.println(">> 1. 연락처 등록");
		System.out.println(">> 2. 모든 연락처 출력");
		System.out.println(">> 3. 연락처 검색 (검색하고자 하는 이름을 입력해 주세요)");
		System.out.println(">> 4. 연락처 삭제 (삭제하고자 하는 이름을 입력해 주세요)");
		System.out.println(">> 5. 연락처 수정 (수정하고자 하는 이름을 입력해 주세요)");
		System.out.println(">> 6. 프로그램 종료");
		System.out.println("------------------------------------------");
		System.out.print(">> ");
	}
	
}
