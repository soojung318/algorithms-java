package com.ezen.dao;

import java.io.*;
import java.util.*;

import com.ezen.vo.EmpVO;
import com.ezen.vo.ITBook;

public class ShopDAO {

	private static String fpath="C:/test/order.txt";
	
	public boolean save(ITBook book) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fpath,true));
			pw.println(book);
			pw.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<ITBook> getList() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fpath));
			String line = null;
			List<ITBook> list = new ArrayList<>();
			
			while((line = br.readLine())!=null) {
				String[] info = line.split("|");
				ITBook book = new ITBook(info[0],info[1],info[2],info[3],Integer.valueOf(info[4]),Integer.valueOf(info[5]));
				list.add(book);
			}
		}catch(Exception e) {
			
		}
		return null;
	}

	public boolean add(ITBook book) {
		// TODO Auto-generated method stub
		return false;
	}


}
