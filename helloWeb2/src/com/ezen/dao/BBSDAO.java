package com.ezen.dao;

import java.io.*;
import java.util.*;

import com.ezen.vo.BBSVO;
import com.ezen.vo.EmpVO;

public class BBSDAO {
	private static String fpath="C:/test/bbs.txt";
	
	public int getLastNo() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fpath));
			String line = null;
			int num = 0;
			while((line=br.readLine())!=null) {
				num = Integer.parseInt(line.split("\\|")[0]);
			}
			return num;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean add(BBSVO bbs) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fpath, true));
			pw.println(bbs);
			pw.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<BBSVO> getList(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(fpath));
			String line = null;
			List<BBSVO> list = new ArrayList<>();
			while((line=br.readLine())!=null) {
				String[] token = line.split("\\|");
				BBSVO bbs = new BBSVO();
				bbs.setNo(Integer.parseInt(token[0]));
				bbs.setTitle(token[1]);
				bbs.setWriter(token[2]);
				bbs.setDate(java.sql.Date.valueOf(token[3]));
				list.add(bbs);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
