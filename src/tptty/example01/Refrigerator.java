package tptty.example01;

import java.util.Scanner;

public class Refrigerator extends HomeAppliance{
	

	public static Scanner scan = new Scanner(System.in);
	
	//필드
	private int temperature = 2;
	
	//생성자
	public Refrigerator(String haName, int temperature) {
		super(haName);
		this.temperature = temperature;
	}

	//get & set
	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	//오버라이딩
	@Override
	public void showStatus() {
		if(this.isHaPower())
			System.out.println(this.getHaName()+", 전원상태 : "+this.isHaPower()+", 냉장온도 : "+this.temperature);
		else
			System.out.println(this.getHaName()+", 전원 꺼져 있음");
	}

	@Override
	public void menu() {
		System.out.println("냉장고를 제어합니다.");
		System.out.print("1)전원 2)냉장온도 \n원하는 메뉴를 선택하세요 : ");
		
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1 : 
			this.setHaPower(!this.isHaPower());
			break;
		case 2 :
			if(this.isHaPower()) {
				System.out.print("냉장온도 입력 : ");
				setTemperature(scan.nextInt());
			}
			else
				System.out.println("전원이 꺼져있습니다.");
			break;
			default :
				System.out.println("입력 메뉴를 확인하세요.");
		}
		System.out.println("냉장고 제어 종료!!");
		
		showStatus();
	}
	
	
	
}
