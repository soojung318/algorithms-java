package review_04_21;

import java.util.Scanner;

//연락처 정보를 관리하는 클래스
public class SmartPhone {

	Scanner in = new Scanner(System.in);
	Contact[] contactArr = new Contact[10];
	int cnt = 0;
	
	//키보드로부터 입력받아 객체 생성
	Contact inputContactData() {
		System.out.print("이름:");
		String name = in.nextLine();
		System.out.print("전화번호:");
		String phoneNumber = in.nextLine();
		System.out.print("이메일:");
		String email = in.nextLine();
		System.out.print("주소:");
		String address = in.nextLine();
		System.out.print("생일:");
		String birthday = in.nextLine();
		System.out.print("그룹:");
		String group = in.nextLine();
		return new Contact(name,phoneNumber,email,address,birthday,group);
	}
	
	//배열에 객체 저장
	void addContact(Contact contact) {
		//inputContactData()에서 입력된 데이터들이 저장되어있는 Contact(...)정보들을 0번지에 저장
		//0번지에 인스턴스들 저장
		contactArr[cnt] = contact;		
		cnt++;
		System.out.printf(">>> 데이터가 저장 되었습니다.(%d)\n",cnt);
	}
	
	//모든 연락처 출력
	void printAllContact() {
		for(int i=0; i<cnt; i++) {
			printContact(contactArr[i]);
		}
	}
	
	//객체 정보 출력
	void printContact(Contact contact) {
		System.out.println("------------------------------------------");
		System.out.println("이름:" + contact.getName());
		System.out.println("전화번호:" + contact.getPhoneNumber());
		System.out.println("이메일:" + contact.getEmail());
		System.out.println("주소:" + contact.getAddress());
		System.out.println("생일:" + contact.getBirthday());
		System.out.println("그룹:" + contact.getGroup());
		System.out.println("------------------------------------------");
	}
	
	//연락처 검색
	void searchContact() {
		String name = in.nextLine();
		for(int i=0; i<cnt; i++) {
			//0번지에 있는 인스턴스들을 contact로 가져와 같은 이름이 잇는지 비교
			//addContact()와 반대
			Contact contact = contactArr[i];
			if(contact.getName().contentEquals(name)) {
				printContact(contact);
				return;
			}
		}
		System.out.println("검색하고자 하는 이름이 없습니다.");
		
	}
	
	void deleteContact() {
		String name = in.nextLine();
		for(int i=0; i<cnt; i++) {
			Contact contact = contactArr[i];
			if(contact.getName().contentEquals(name)) {
				for(int j=i; j<cnt; j++) {
					contactArr[j] = contactArr[j+1];
				}
				cnt--;//??
				return;
			}
		}
		System.out.println("삭제하고자 하는 이름이 없습니다.");
	}
	
	void editContact(String name, Contact newContact) {
		
		for(int i=0; i<cnt; i++) {
			if(contactArr[i].getName().contentEquals(name)) {
				contactArr[i] = newContact;
				return;
			}
		}
		System.out.println("검색결과가 없습니다.");
	}
}
