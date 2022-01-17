package tptty.example05;

public class TestMain {

	public static void main(String[] args) {
		Window win = new Window(); //객체 생성
		win.callBtn.touch(); //window에 있는 전화버튼 touch
		win.callBtn2.touch(); 
		win.msgBtn.touch(); //window에 있는 메세지버튼 touch
		//오류발생 : 아무런 이벤트가 발생되지 않음
		//오류원인 : touch()에 가보면, listener가 존재해야만 작업 수행 (현재 : listener==null인 상태)
		//해결방안 : listener정보 필요 : 인터페이스 OnClickListener구현
	}

}
