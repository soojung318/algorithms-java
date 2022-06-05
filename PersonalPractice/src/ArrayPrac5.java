//배열을 만들어 반복문을 이용하여 아래와 같이 저장한 후 출력하는 프로그램 (첫 번째 행은 전부 1로 초기화한후 내거 왼쪽 + 바로 위 값을 더해서 저장 - 배열의 크기 5행 5열)

public class ArrayPrac5 {

	public static void main(String[] args) {
		int[][] a = new int[5][5]; 
		int i, j; 
		for( j=0; j<a[4].length; j++) { 
			a[0][j] = 1; 
			System.out.printf("%2d ", a[0][j]); 
			} 
		System.out.println(); 
		
		for( i=1; i<a.length; i++) { 
			for( j=0; j<a[i].length; j++) {
				if( j==0) { a[i][j] = a[i-1][j]; 
				} else {
					a[i][j] = a[i-1][j] + a[i][j-1]; 
					} 
				System.out.printf("%2d ", a[i][j]); 
				} 
			System.out.println(); 
			}


	}

}
