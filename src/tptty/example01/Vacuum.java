package tptty.example01;

import java.util.Scanner;

public class Vacuum extends HomeAppliance implements IoTInterface{
	//청소기 원격제어를 위해 인터페이스 IoTInterface를 implements할 것
	//추상메소드를 반드시 오버라이딩


	public static Scanner scan = new Scanner(System.in);
	
	private int level = 1;

	public Vacuum(String haName, int level) {
		super(haName);
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public void showStatus() {
		if(this.isHaPower())
			System.out.println(this.getHaName()+", 전원상태 : "+this.isHaPower()+", 청소기 세기 : "+this.level);
		else
			System.out.println(this.getHaName()+", 전원 꺼져 있음");
	}

	@Override
	public void menu() {
		System.out.println("청소기를 제어합니다.");
		System.out.println("1)전원 2)청소 레벨 \n원하는 메뉴를 선택하세요 : ");
		
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1 : 
			this.setHaPower(!this.isHaPower());
			break;
		case 2 :
			if(this.isHaPower()) {
				System.out.println("청소 레벨 입력(1~3) : ");
				this.setLevel(scan.nextInt());
				if(level>=1 && level <=3) {
					this.setLevel(level);
				}
				else
					this.setLevel(1);
				System.out.println("청소 강도 "+this.level+"로 동작중입니다.");
			}
			else
				System.out.println("전원이 꺼져있습니다.");
			break;
			default :
				System.out.println("입력 메뉴를 확인하세요.");
		}
		System.out.println("청소기 제어 종료!!");
		
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
