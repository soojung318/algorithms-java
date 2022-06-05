package review_04_17;

public class Member {

	String name;		// 이름
	String phoneNumber;	// 전화번호
	String major;		// 전공
	int grade;			// 학년
	String email;		// 이메일
	String birthday;	// 생일
	String address;		// 주소
	
	//모든 멤버 변수들의 초기화
	public Member(String name, String phoneNumber, String major, int grade, String email, String birthday, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
	}
	
	// 생일과 주소 정보를 받지 않는 생성자
	public Member(String name, String phoneNumber, String major, int grade, String email) {
		//this(name,phoneNumber,major,grade,email,null,null); //이미 정의된 생성자 호출
		this(name, phoneNumber, major, grade, email, "정보없음", "정보없음");	//이미 정의된 생성자 호출
	}
	
	//정보 출력 메소드
	public void printInfo() {
		System.out.println("이름: " + this.name);
		System.out.println("전화번호: " + this.phoneNumber);
		System.out.println("전공: " + this.major);
		System.out.println("학년: " + this.grade);
		System.out.println("이메일: " + this.email);
		System.out.println("생일: " + this.birthday);
		System.out.println("주소: " + this.address);
	}
	
	public static void main(String[] args) {
		//new 연산자 교재 218
		Member member1 = new Member("SHKIM","010-9999-7777","컴퓨터",2,"shkim@gmail.com","2000-10-11","서울");
		member1.printInfo();
		
		System.out.println("---------------------------------");
		
		Member member2 = new Member("JJKIM","010-1111-3333","컴퓨터",2,"jjkim@gmail.com");
		member2.printInfo();

	}

}
