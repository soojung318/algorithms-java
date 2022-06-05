package review_04_19;
//미니프로젝트 #1
public class Contact {

	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthday;
	private String group;
	//저장정보 = 그룹
	
	//생성자
	Contact(String name, String phoneNumber, String email, String address, String birthday, String group){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	
	// 내가 바로 떠오르지 못했던 부분
	public void printInfo(){
		 System.out.printf("이름: %s\n 전화번호:%s\n 이메일:%s\n 주소:%s\n 생일:%s\n 그룹:%s\n",
                 name, phoneNumber, email, address, birthday, group);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	
	
}
