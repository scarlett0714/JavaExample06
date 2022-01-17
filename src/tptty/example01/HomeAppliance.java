package tptty.example01;

public abstract class HomeAppliance {

	//필드
	protected String haName; //가전제품 이름
	protected boolean haPower = false; //전원정보 : 꺼짐(false)
	
	//생성자
	public HomeAppliance(String haName) {
		super();
		this.haName = haName;
	}
	
	//get & set
	public String getHaName() {
		return haName;
	}
	public boolean isHaPower() {
		return haPower;
	}
	
	//메소드
	public void setHaName(String haName) {
		this.haName = haName;
	}
	
	public void setHaPower(boolean haPower) {
		this.haPower = haPower;
	}
	
	
	//직접적으로 사용하지는 않으나 자식클래스에서 오버라이드할 수 있도록 만듦
	public abstract void showStatus();
	
	public abstract void menu();
	
}
