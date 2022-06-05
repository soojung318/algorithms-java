//김범준
package review_04_19;
import java.util.Scanner;

//import mini_project2.SmartPhone;

public class SmartPhoneMain {
	
	public static void main(String[] args) {
		SmartPhone phone = new SmartPhone();

//		for(int i=1; i<=5; i++) {
//			System.out.println("# 데이터 2개를 입력합니다.");
//			phone.addContact(phone.inputContactData());
//			phone.addContact(phone.inputContactData());
//		}

		System.out.println("# 데이터 2개를 입력합니다.");
		phone.addContact(phone.inputContactData());
		phone.addContact(phone.inputContactData());
		
		printMenu(phone);
	}
	
	static void printMenu(SmartPhone smartPhone) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Contact------------");
			System.out.println(">> 1. 연락처 등록");
			System.out.println(">> 2. 모든 연락처 출력");
			System.out.println(">> 3. 연락처 검색");
			System.out.println(">> 4. 연락처 삭제");
			System.out.println(">> 5. 연락처 수정");
			System.out.println(">> 6. 프로그램 종료");
			System.out.println("------------------");
			System.out.print(">> ");
			int menuNum = scan.nextInt();
			while(menuNum<1 || menuNum >6) {
				System.out.println("1번부터 6번까지 입력해주세요.");
				menuNum = scan.nextInt();
			}
			
			switch(menuNum) {
			case 1:
				smartPhone.addContact(smartPhone.inputContactData());
				break;
			case 2:
				smartPhone.printAllContact(smartPhone.contacts);
				break;
			case 3:
				smartPhone.searchContact();
				break;
			case 4:
				smartPhone.deleteContact();
				break;
			case 5:
				smartPhone.editContact();
				break;
			case 6:
				System.out.println("종료합니다.");
				System.exit(0);
			}
			
		}
	}

}
