package tptty.example05;

import tptty.example05.Button.OnClickListener;

public class CallListener implements OnClickListener { //각각의 버튼별로 다르게 수행되는 것

	@Override
	public void onClick() {
		System.out.println("전화합니다.");
	}

}
