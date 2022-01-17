package tptty.example01;

import java.util.Scanner;

public class TV extends HomeAppliance {
	
	static Scanner scan = new Scanner(System.in);
	
	//필드
	private int channel = 10;
	
	//생성자
	public TV(String haName, int channel) { //부모 생성자에게 이름을 넘겨줄 생성자가 필요 : haName
		super(haName); //내 멤버가 아닌 것은 부모에게 넘기기(haName) /channel은 내 멤버
		this.channel = channel;
		
	}

	//get & set
	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	//오버라이딩
	@Override
	public void showStatus() {
		if(this.isHaPower()) //전원이 켜져있으면, 상태정보 출력
			System.out.println(this.getHaName()+", 전원상태 : "+this.isHaPower()+", 채널 : "+channel+"시청중");
		else //전원이 꺼져있으면, 꺼진 상태 출력
			System.out.println(this.getHaName()+", 전원 꺼져 있음");
	}

	@Override
	public void menu() {
		
		System.out.println("TV를 제어합니다.");
		System.out.print("1)전원 2)채널 \n원하는 메뉴를 선택하세요 : ");
		
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1 : //전원변경
			this.setHaPower(!this.isHaPower()); //현재전원과 반대되는 상태가 입력됨
			break;
		case 2 : //채널변경
			if(this.isHaPower()) { //전원이 켜져있을 때,
				System.out.print("채널 입력 : ");
				setChannel(scan.nextInt());
			}
			else { //전원이 꺼져있을 경우,
				System.out.println("전원이 꺼져있습니다.");
			}
			break;
			default : 
				System.out.println("입력 메뉴를 확인하세요.");
		}
		System.out.println("TV 제어 종료!!");
	
		showStatus();
	}
	
	
	
	
	
}
