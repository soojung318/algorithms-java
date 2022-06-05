package review_04_17;

public class Calculator {
	static int x;
	static int y;
	static int res = 0;
	
	static int sum(int x, int y) {
		res = x + y;
		return res;
	}
	static int sub(int x, int y) {
		res =  x - y;
		return res;
	}
	static int mul(int x, int y) {
		res = x * y;
		return res;
	}
	static int div(int x, int y) {
		res =  x / y;
		return res;
	}
	
	public static void main(String[] args) {
	// main()에 public을 사용하지 않을경우:
	// 클래스에서 기본 메소드를 찾지 못함.
	// 자세한 설명 : http://egloos.zum.com/silverer/v/1875796 
		x = 15;
		y = 3;
	
		sum(x,y);
		sub(x,y);
		mul(x,y);
		div(x,y);

		System.out.println("덧셈 = " + sum(x,y));
		System.out.println("뺼셈 = " + sub(x,y));
		System.out.println("곱셈 = " + mul(x,y));
		System.out.println("나눗셈 = " + div(x,y));
	}

}
