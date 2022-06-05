import java.util.*;

public class Hello {

	public static void main(String[] args) {
		//List<Object> list = new ArrayList<>();
	//	list.add("Hello");	//오브젝트로 문자열 객체 추가.
		
	//	Object objString = list.get(0);	// list.get(0)이 오브젝트 이므로 Object 타입으로 이어서 받아야 함.
		//String objString= list.get(0); -->에러
		
		// byte, short, int, long, char, float, double, boolean
		// Byte, Short, Integer, Long, Character, Float, Double, Boolean
		// Wrapper 클래스
		int a = 10;	//Integer.parseInt
		Integer it = Integer.valueOf(a);
		//it. <-- 이렇게 하면 안된다.
		//List<컬렉션> 에서 컬렉션안에 일반 자료형이 못들어가니까 wrapper 클래스를 쓰는 것이다.
		List<Integer> list = new ArrayList<>();
		list.add(3);	//3이라는 int형 숫자가 들어가는 것이 아니라 Integer.valueOf(3);라는 객체가 들어가는 것이다.	
		
		Integer it2 = list.get(0);
		//int b = it2.intValue();
		int b = it2;		//바로 위 줄과 같은 의미.개발자편의를 위해서 만들어짐.
		int b2 = list.get(0);
		/*list.add(it);
		
		Integer it2 = list.get(0);
		int iv = it2.intValue();
		System.out.println("iv="+iv);
		
		int b = it2;// Unboxing: 이렇게도 되지만 3줄위처럼 하는게 가장 베스트다.
		
		//Integer it3 = 100;		// Auto-Boxing
		Integer it3 = Integer.valueOf(100);*/
	}

}
