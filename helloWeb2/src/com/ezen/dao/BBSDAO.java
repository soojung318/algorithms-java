package com.ezen.dao;

import java.io.*;
import java.util.*;

import com.ezen.vo.BBSVO;
import com.ezen.vo.EmpVO;
import com.ezen.vo.UserVO;

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
			br.close();
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
				System.out.println("dao:"+token[0]);
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
	

	public BBSVO getBBS(int num) 
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(fpath));
			String line = null;
			int _num = 0;
			while((line=br.readLine())!=null) {
				String[] token = line.split("\\|");
				_num = Integer.parseInt(token[0]);
				if(num==_num) {
					BBSVO bbs = new BBSVO();
					bbs.setNo(Integer.parseInt(token[0]));
					bbs.setTitle(token[1]);
					bbs.setWriter(token[2]);
					bbs.setDate(java.sql.Date.valueOf(token[3]));
					bbs.setContent(token[4]);
					br.close();
					return bbs;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean update(BBSVO newBbs) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fpath));
			String line = null;
			List<BBSVO> list = new ArrayList<>();
			while((line=br.readLine())!=null) {
				String[] token = line.split("\\|");
				BBSVO bbs = new BBSVO(token);
				if(bbs.equals(newBbs)) {
					bbs.setTitle(newBbs.getTitle());
					bbs.setContent(newBbs.getContent());
				}
				list.add(bbs);
			}
			return overwrite(list);	//새로바뀐 정보를 기존의 정보에 덮어쓴다.
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean overwrite(List<BBSVO> list) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fpath));
			for(int i=0; i<list.size(); i++) {
				pw.println(list.get(i));
			}
			pw.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
