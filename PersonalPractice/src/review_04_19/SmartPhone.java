//김범준
package review_04_19;
import java.util.*;
public class SmartPhone {

	Scanner scan = new Scanner(System.in);
	Contact[] contacts = new Contact[10];
	
	public Contact inputContactData() {
		System.out.print("이름: ");
		String inputName = scan.nextLine();
		
		System.out.print("전화번호: ");
		String inputPhoneNumber = scan.nextLine();
		
		System.out.print("이메일: ");
		String inputEmail = scan.nextLine();
		
		System.out.print("주소: ");
		String inputAddress = scan.nextLine();
		
		System.out.print("생일: ");
		String inputBirthday = scan.nextLine();
		
		System.out.print("그룹: ");
		String inputGroup = scan.nextLine();
		
		Contact inputContact = new Contact(inputName, inputPhoneNumber, inputEmail,
										inputAddress, inputBirthday, inputGroup);
		return inputContact;
	}
	
	public void addContact(Contact contact) {
		int blankIndex = -1;
		for(int i=0; i<contacts.length; i++) {
			if(contacts[i] == null) { 
				blankIndex = i; 
				break;
			}
		}
		
		if(blankIndex == -1) {
			System.out.println("연락처 공간이 꽉차서 저장할 수 없습니다.");
			return;
		} 
		
		contacts[blankIndex] = contact;
		System.out.println("데이터가 저장되었습니다. (" + (blankIndex+1) + ")");
	}
	
	public void printContact(Contact contact) {
		System.out.printf("이름: %s, 전화번호: %s, 이메일: %s, 주소: %s, 생일: %s, 그룹: %s \n",
				contact.getName(), contact.getPhoneNumber(), contact.getEmail(),
				contact.getAddress(), contact.getBirthday(), contact.getGroup());
	}
	
	public void printAllContact(Contact[] contacts) {
		for(int i=0; i<contacts.length; i++) {
			if(contacts[i]==null) continue;
			
			printContact(contacts[i]);
		}
	}
	
	public void searchContact() {
		int index = -1;
		System.out.println("검색하고자 하는 이름을 입력해주세요.");
		String addressName = scan.nextLine();
		
		for(int i=0; i<contacts.length; i++) {
			if(contacts[i]==null) continue;
			
			if(contacts[i].getName().contentEquals(addressName)) {
				index = i;
				break;
			}
		}
		
		if(index == -1) {
			System.out.println("해당 연락처를 찾을 수 없습니다.");
			return;
		}
		printContact(contacts[index]);
			
	}
	
	public void deleteContact() {
		int index = -1;
		System.out.println("삭제하고자 하는 이름을 입력해주세요.");
		String deleteName = scan.nextLine();
		
		for(int i=0; i<contacts.length; i++) {
			if(contacts[i]==null) continue;
			
			if(contacts[i].getName().contentEquals(deleteName)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("해당 연락처를 찾을 수 없습니다.");
			return;
		}
		contacts[index] = null;
	}
	
	public void editContact() {
		int index = -1;
		System.out.println("수정하고자 하는 이름을 입력해 주세요.");
		String correctName = scan.nextLine();
		
		for(int i=0; i<contacts.length; i++) {
			if(contacts[i]==null) continue;
			
			if(contacts[i].getName().contentEquals(correctName)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("해당 연락처를 찾을 수 없습니다.");
			return;
		}
		
		System.out.println("지금부터 입력할 내용으로 연락처를 수정합니다.");
		contacts[index] = inputContactData();
	}
	
	
	
}
