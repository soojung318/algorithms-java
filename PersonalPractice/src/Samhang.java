
//2022-05-25 실습2 삼항연산자.
public class Samhang{

	public static void main(String[] args) {
		double num = Math.random();
		int n = (int)(num * 9)+0;
		
		String res =(n%2==0) ? "짝수" : "홀수";
		System.out.println(res);
	}
	

}
