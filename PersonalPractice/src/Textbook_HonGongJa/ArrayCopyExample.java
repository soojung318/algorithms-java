package Textbook_HonGongJa;

public class ArrayCopyExample {

	public static void main(String[] args) {
		// p.196 System.arraycopy()로 배열복사 
		String[] oldStrArray = { "java", "array", "copy"};
		String[] newStrArray = new String[5];
		
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);	//시스템 어레이로 배열복사
		
		for(int i=0; i<newStrArray.length; i++) {
			System.out.print(newStrArray[i] + ",");
		}
	}

}
