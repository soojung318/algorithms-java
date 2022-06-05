//  문제) 3행 5열의 배열을 출력예처럼 초기화한 후 형식에 맞추어 출력하는 프로그램(사이의 공백은 3칸으로 하고 각 수는 2칸으로 오른쪽 맞추어 출력) 
public class ArrayPrac1 {

	public static void main(String[] args) {
		int[][] a = new int[][] {{5,8,10,6,4},{11,20,1,3,2},{7,9,14,22,3}};
		
		for(int i=0; i<a.length; i++) {		//3개의 큰 덩어리 배열
			for(int j=0; j<a[i].length; j++){	// 1개의 큰 덩어리 배열 내의 값을 도출 하므로 a[i]
				System.out.printf("%2d  ",a[i][j]);
			}
			System.out.println();
		}
		
	}

}
