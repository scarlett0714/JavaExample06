package tptty.example03;

public class TestMain {

	public static void main(String[] args) {
		//객체 생성
		Television tv = new Television();
		Audio audio = new Audio();
		
		//tv 타입 : Television, audio 타입 : Audio, rc 타입 : RemoteControl
		//타입이 다른데 어떻게 대입가능?
		//인터페이스인 RemoteControl이 부모클래스의 역할을 하므로 자동으로 업캐스팅 (다운캐스팅도 가능)
		RemoteControl rc = tv;
		rc.turnOn(); //tv전원이 켜짐
		rc.setMute(true); //디폴트메소드로 구현된 setMute
		//내용수정을 원하면 오버라이딩해서 재정의
		
		rc = audio;
		rc.turnOn(); //audio전원이 켜짐
		
		RemoteControl.changeBattery(); //static메소드
		
		rc = new Television(); //위와 같은 객체 생성도 가능, 지금 이 방법도 가능
		if(rc instanceof Television) //instanceof : rc의 실제타입이 무엇인가?(실제객체의 타입식별)
			System.out.println("현재 TV리모콘으로 사용중");
		else if(rc instanceof Audio)
			System.out.println("현재 Audio리모콘으로 사용중");
		
		//인터페이스 배열 선언
//		RemoteControl[] rc1 = new RemoteControl[2]; //빈 방 2개 생성 = 객체x(객체로 초기화된 것x), 그냥 참조변수 2개 선언된 것과 같음
		//new RemoteControl(); (x) -> 생성자를 호출하여 객체 생성은 불가능
		
		RemoteControl[] rc2 = { //배열생성과 동시에 초기화 -> 빈 방x
				new Television(),
				new Audio()
		};
		
		for(RemoteControl r : rc2) {
			if(r instanceof Television) { //타입식별
				Television tv1 = (Television)r; //다운캐스팅
				tv1.turnOff(); //가전제품 중 tv만 turnOff실행
				//Q : r.turnOff()와 tv1.turnOff()는 뭐가 다르지?
				//A : 
				//만약 다운캐스팅없이 r.turnOff()한다면?
				//모든 가전제품이 turnOff를 호출
			}
		}

	}

}
