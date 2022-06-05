//파스칼삼각형을 출력하는 프로그램 작성. 파스칼삼각형은 첫번째 줄 첫번째 행은 1로 초기화한후 다음줄부터 바로 위 값과 바로위 왼쪽의 값을 더한 값이 적용됨. (6행6열 배열로 풀이)

public class ArrayPrac4 {

	public static void main(String[] args) {
		int[][] a = new int[6][6]; 
		int i, j; 
		a[1][1] = 1; 
		
		for( i=2; i<a.length; i++) {
			for( j=1; j<=i; j++) { 
				a[i][j] = a[i-1][j-1] + a[i-1][j]; 
				} 
			}
		
		for( i=1; i<a.length; i++) { 
			for( j=1; j<=i; j++) {
				System.out.print(a[i][j]); 
				} 
			System.out.println(); 
			}

	}

}
