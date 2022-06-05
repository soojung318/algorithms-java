package Textbook_HonGongJa;
//p.195
public class ArrayReferenceObjectExample {

	public static void main(String[] args) {
		String[] strArray = new String[3];
		
		strArray[0] = "java";
		strArray[1] = "java";
		strArray[2] = new String("java");
		
		System.out.println(strArray[0] == strArray[1]);			//같은 객체 참조 비교 : true
		System.out.println(strArray[0] == strArray[2]);			//같은 객체 참조 비교 : false
		System.out.println(strArray[0].equals(strArray[2]));	//문자열 비교
	}

}
