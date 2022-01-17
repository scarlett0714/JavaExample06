package tptty.example03;

//Television과 Audio의 부모 : RemoteControl(인터페이스) = 상속에서의 클래스와 같은 역할
//인터페이스는 그 인터페이스를 구현한, 구현클래스의 부모클래스가 됨(부모역할 수행가능) = 구현객체의 부모 클래스
public class Television implements RemoteControl {

	private int volume;
	
	//오버라이딩 : 하나라도 오버라이딩하지 않으면 추상클래스로 변환
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : "+this.volume);
		
	}

}
