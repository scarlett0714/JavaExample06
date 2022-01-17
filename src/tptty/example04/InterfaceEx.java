//인터페이스 상속 및 구현 예제
package tptty.example04;

interface PhoneInterface { 
	int BUTTONS = 20;
	void sendCall(); //전화 걸기
	void receiveCall(); //전화 받기
}

interface MobilePhoneInterface extends PhoneInterface { //PhoneInterface로 부터 상속받아 추가기능
	void sendSMS(); //문자 보내기
	void receiveSMS(); //문자 받기
}

interface MP3Interface { //MP3
	public void play();
	public void stop();
}

class PDA { //계산기기능
	public int calculate(int x, int y) {
		return x+y;
	}
}

//클래스 PDA 상속, 인터페이스 MobilePhoneInterface, MP3Interface 상속
//클래스는 단일상속만 가능 : PDA기능 상속받아서 계산기기능추가
//인터페이스는 다중상속 가능 : 현재 추상메소드만 가지고 있는 상태(이름만 가지고 있는 상태) -> SmartPhone방식대로 재정의 필요

//인터페이스는 반드시 오버라이딩필요
class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface {
	public void sendCall() { //어떤 스마트폰을 구현하던 sendCall()과 같은 메소드이름은 동일 but 내부적으로는 다름
		System.out.println("전화 걸기");
	}
	public void receiveCall() {
		System.out.println("전화 받기");
	}
	public void sendSMS() {
		System.out.println("SMS 보내기");
	}
	public void receiveSMS() {
		System.out.println("SMS 받기");
	}
	
	//MP3
	public void play() {
		System.out.println("음악 재생");
	}
	public void stop() {
		System.out.println("재생 중지");
	}
	
	//본인만의 메소드 추가
	public void schedule() {
		System.out.println("일정 관리");
	}

}

public class InterfaceEx {

	public static void main(String[] args) {
		SmartPhone p = new SmartPhone(); //객체생성
		p.sendCall();
		p.play();
		System.out.println(p.calculate(3,5));
		p.schedule();

	}

}
