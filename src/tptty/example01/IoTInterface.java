package tptty.example01;

public interface IoTInterface{
	
	//abstract이 없어도 body부분이 없으므로 자동으로 abstract메소드 (class는 반드시 abstract명시)
	void turnOn();
	void turnOff();
	void contorl();
}
