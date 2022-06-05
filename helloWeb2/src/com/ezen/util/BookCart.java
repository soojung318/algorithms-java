package com.ezen.util;

import java.util.*;

import com.ezen.vo.ITBook;

public class BookCart {
	
	private List<ITBook> list = new ArrayList<>();
	
	public boolean save(ITBook book) {//book은 장바구니 담겠다고 한 책 정보
		//책을 장바구니에 담기전에 이미 담았는지 확인.. 수량만 올릴것인가 새로 추가할 것인가
		//같은 책이 있는지 인덱스로 확인
		//equlas메소드로 확인하는 코드가 없는 이유는 VO에 equals메소드를 미리 만들어놨기 떄문에
		int idx = list.indexOf(book);		//idx =index(색인)
		
		if(idx==-1) {	//같은 index가 배열리스트에 없으면..
			list.add(book);	// 전송된 데이터 그대로 저장(추가)
		}else {// 수량만 더해줌
			int qty1 = list.get(idx).getQty();	//이미 장바구니에 있는 책의 수량을 먼저 구함
			list.get(idx).setQty(qty1 + book.getQty());	//기존의 책의 수량과 새롭게 장바구니에 들어온 책의 수량을 더해줌.
		}
		return true;
	}
	
	
	public List<ITBook> getCart(){
		return list;
	}
	
	public int getTotal() {
		int total = 0 ;
		for(int i=0; i<list.size(); i++) {
			ITBook book = list.get(i);
			total += book.getPrice() * book.getQty();
		}
		return total;
	}


	public boolean updatedQty(int idx, int qty) {
		List<ITBook> list =  getCart();
		list.get(idx).setQty(qty);
		return true;
	}
	public boolean delete(int idx) {
		List<ITBook> list =  getCart();
		list.remove(idx);
		return true;
	}


	public boolean deleteAll() {
		list.clear();
		return true;
	}
	
}
