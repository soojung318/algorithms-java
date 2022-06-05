package Textbook_HonGongJa;
//ch07.상속 321쪽
public class DmbCellPhone extends CellPhone{

	//필드
	int channel;
	
	//생성자
	DmbCellPhone(String model, String color, int channel){
		//model과 color는 CellPhone클래스로부터 상속받은 필드
		//extends 안쓰면 에러남
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	//메소드
	void turnOnDmb() {
		System.out.println("채널 " + channel +"번 DMB 방송 수신을 시작합니다.");
	}
	void changeChannelDmb(int channel) {
		this.channel = channel;		//내 클래스에 있던 channel 필드에 외부에서 받아온 channel 값을 대입 하겠다.
		System.out.println("채널 " + channel +"번으로 바꿉니다.");
	}
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 시작합니다.");
	}
}
