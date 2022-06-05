package Textbook_HonGongJa;

public class ArrayCopyByForExample {

	public static void main(String[] args) {
		// p.195 for문으로 배열복사
		int[] oldIntArray = { 1, 2, 3 };
		int[] newIntArray = new int[5];
		
		for(int i =0; i<oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];		//배열 복사
		}
		
		for(int i=0; i<newIntArray.length; i++) {
			System.out.print(newIntArray[i] + ", ");
		}
	}

}
