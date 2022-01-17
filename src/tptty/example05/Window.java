package tptty.example05;

import tptty.example05.Button.OnClickListener;

public class Window implements OnClickListener{ //만약 모든 버튼의 수행이 똑같이 일어난다면("버튼이 클리됨"),
	
	//Window에 Button객체 2개 생성
	Button callBtn = new Button("전화");
	Button callBtn2 = new Button("전화");
	Button msgBtn = new Button("메세지");
	
	CallListener callListener = new CallListener(); //여러객체들이 공유하는 기능일 경우
	
	//오류발생 : public Window()를 구현하지않으면 onClick을 오버라이딩만 한 상태에서는 호출되지 않음
	//오류원인 : listener를 구현은 했으나 그 정보를 callBtn, msgBtn에 등록하지 않음
	public Window() {
		//listener정보 초기화 : Window가 구현했으므로 인자 : (this)->Window에 있는 "버튼이 출력됨"출력
		callBtn.setOnClickListener(new CallListener()); //listener정보 초기화 : 객체 생성
		callBtn2.setOnClickListener(callListener); //listener정보 초기화 : 위에서 생성한 객체를 사용 (위에 코드와 같은 방법)
		
		//msgBtn에서만 사용된다면, 굳이 CallListener처럼 클래스를 따로 만들 필요 없이 익명 객체 사용 (인자로) *밖에서는 참조불가능
		msgBtn.setOnClickListener(new OnClickListener() { //인터페이스는 객체를 만들 수x -> 뒤에 body를 붙이면 객체가능
			
			//인터페이스를 생성했으므로 body부분에 onClick오버라이딩 필요
			@Override
			public void onClick() {
				System.out.println("메세지를 보냅니다.");
			} 
			
		});
	}
	
	
	@Override
	public void onClick() { //상속받은 OnClickListener사용을 위해 onClick오버라이딩
		System.out.println("버튼이 클릭됨");
	}
	
}
