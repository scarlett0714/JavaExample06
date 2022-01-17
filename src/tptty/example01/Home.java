package tptty.example01;

import java.util.Scanner;

public class Home {

	public static Scanner scan = new Scanner(System.in);
	
	//필드
	private HomeAppliance[] apps; //가전제품정보 들여오기 : 부모클래스로 지정
	private final int capacity; //집에 들여놓을 수 있는 가전제품 수
	private int count = 0; //현재 들어와있는 가전제품 수 카운트
	
	//생성자
	public Home(int capacity) {
		super();
		this.capacity = capacity;
		//배열생성
		apps = new HomeAppliance[this.capacity]; //빈 방 생성
	}
	
	//메소드
	public void buyHA(HomeAppliance ha) { //가전제품 살 때의 메소드(모든 가전제품을 받을 수 있어야함)->매개변수 : 부모의 타입으로 지정(다형성)
		if(this.count<this.capacity) { //배열에 공간이 있을 경우
			apps[count++] = ha;
		}
		else
			System.out.println("더이상 공간이 없음!");
		}
	
	public void scanIoTDevice() { //원격제어기능을 가진 장치만 검색
		System.out.println("원격 제어할 가전제품을 선택하세요!!");
		for(int i=0;i<count;i++) {
			if(apps[i] instanceof IoTInterface) //배열에 있는 가전제품이 IoTInterface를 구현한 제품이면,
				System.out.println((i+1)+")"+apps[i].getHaName());
		}
	}
	
	public IoTInterface connect() {//원격제어가능제품 중 제품을 선택하면 그 제품을 반환
		scanIoTDevice();
		System.out.print("제품을 선택해 주세요 : ");
		int i = scan.nextInt();
		return (IoTInterface) apps[i-1]; 
	}

	public void open() { //모든 가전제품 제어 가능
		while(true) { //[Ctrl]+[shift]+f : 자동정렬(들여쓰기)
			System.out.println("제어할 가전제품을 선택하세요!!");
			int i = 1;
			for (HomeAppliance ha : apps) { // apps배열에 있는 가전제품들에 대한 반복문
				// 배열은 null값이 들어갈 수 있으므로, 조건문으로 예외처리필요
				if (ha != null) { // 빈 방이 아니면,
					System.out.println(i + ")" + ha.getHaName()); // 해당 가전제품의 이름 가져오기
					i++;
				}
			}

			// for each구문과 같은 코드
//		for(int i =0; i<count; i++) {
//			System.out.println((i+1)+")"+apps[i].getHaName()); //해당 가전제품의 이름 가져오기
//			i++;
//		}

			System.out.print("제품을 선택해 주세요 : ");
			int index = scan.nextInt();
			if (index >= 1 && index <= count) {
				//각 자식클래스가 오버라이딩한 menu()메소드 출력 (다형성)
				//부모의 menu가 실행되지는 않지만 상속을 위해 부모클래스에서 menu가 선언되어있어야함
				apps[index - 1].menu(); // 위 출력구문에서 0번방인데 1로 출력
			}
			else { //index값 이외의 값이 입력된다면,
				System.out.println("가전제품 제어를 종료합니다.");
				break;
			}
		}
		
	}
	
}
