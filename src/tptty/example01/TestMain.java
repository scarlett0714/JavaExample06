package tptty.example01;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("202110547 황윤선");
		
		Home home = new Home(10); //가전제품 10개까지 들여놓을 수 있는 집 생성
		
		//가전제품 사기
		home.buyHA(new TV("건국TV", 15));
		home.buyHA(new Refrigerator("건국냉장고", 0));
		home.buyHA(new Boiler("건국보일러", 20));
		home.buyHA(new Vacuum("건국청소기", 1));
		home.buyHA(new TV("대학TV", 10));
		
//		//집 열고 들어가기(가전제품 사용 가능 상태)
//		home.open(); //직접제어
		
//		home.scanIoTDevice(); //원격제어
		
		IoTInterface iot = home.connect();
		if(iot!=null){
			iot.turnOn();
			iot.contorl();
			iot.turnOff();
		}else {
			System.out.println("connect 실패!!");
		}
	}

}
