package tptty.example05;
//사용자가 아직 등장하지 않음


//특정클래스에서 다른클래스가 가진 멤버들을 알 수 없음
//but 다른객체가 가진 메소드를 호출했으면 좋겠음
//내가 호출하고 싶은 메소드를 중첩인터페이스로 정의

public class Button { 
	//멤버
	private String caption; //버튼별로 표시되는 캡션
	private OnClickListener listener;
	//내 버튼을 사용하려면 OnClickListener인터페이스를 사용해
	//->니가 구현한 정보를 set함수를 통해서 나한테 등록해줘
	//->내 버튼을 touch하면 니가 구현한 onClick메소드를 구현해줄게

	//생성자
	public Button(String caption) {
		super();
		this.caption = caption;
	}
	
	//get & set
	//null값으로 초기화된 listener의 값을 변경
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}

	//인터페이스
	//버튼이라는 형태는 모두 같지만, 각 버튼별로 눌렀을 때 실행되는 작업이 다름 -> 인터페이스 활용 (연결작업)
	static interface OnClickListener { //중첩인터페이스
		void onClick(); //추상메소드
		//누군가는 Button에서 정의된 OnClickListener인터페이스를 구현->구현된 인터페이스 정보를 받아야함 : listener
	}
	
	//메소드
	public void touch() { //touch의 용도는 버튼별로 다양하지만 Button클래스에서 그걸 정의할 필요는 없음
		if(listener!=null) { //listener가 등록되어있다면,
			listener.onClick(); //사용자의 onClick호출해줄게
		}
	}
	
}
