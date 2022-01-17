package tptty.example01;

import java.util.Scanner;

public class Boiler extends HomeAppliance implements IoTInterface {

	public static Scanner scan = new Scanner(System.in);
	
	//필드
	private int temperature = 2;
	
	//생성자
	public Boiler(String haName, int temperature) {
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
			System.out.println(this.getHaName()+", 전원상태 : "+this.isHaPower()+", 보일러 온도 : "+this.temperature);
		else
			System.out.println(this.getHaName()+", 전원 꺼져 있음");
	}

	@Override
	public void menu() {
		System.out.println("보일러를 제어합니다.");
		System.out.print("1)전원 2)난방 온도 \n원하는 메뉴를 선택하세요 : ");
		
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1 : 
			this.setHaPower(!this.isHaPower());
			break;
		case 2 :
			if(this.isHaPower()) {
				System.out.print("난방 온도 입력 : ");
				setTemperature(scan.nextInt());
			}
			else
				System.out.println("전원이 꺼져있습니다.");
			break;
			default :
				System.out.println("입력 메뉴를 확인하세요.");
		}
		System.out.println("보일러 제어 종료!!");
		
		showStatus();
	}

	//IoTInterface 인터페이스의 추상메소드 오버라이딩
	@Override
	public void turnOn() {
		this.setHaPower(true);
		
	}

	@Override
	public void turnOff() {
		this.setHaPower(false);
		
	}

	@Override
	public void contorl() {
		menu();
		
	}
	
	
	
	

}
