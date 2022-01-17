//추상 클래사의 구현 예제
//심화 추상클래스 예시 : JavaExample05->tptty.example04->Ticket
package tptty.example02;

public class GoodCalc extends Calculator {

	//객체를 생성하기 위한 오버라이딩
	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public double average(int[] a) {
		double sum = 0;
		for(int i = 0;i<a.length;i++)
			sum += a[i];
		return sum/a.length;
	}
	
	public static void main(String[] args) {
		GoodCalc c = new GoodCalc();
		System.out.println(c.add(2, 3));
		System.out.println(c.subtract(2, 3));
		System.out.println(c.average(new int[] {2,3,4,} ));
	}

}
