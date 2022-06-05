package com.ezen.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.ezen.vo.EmpVO;
import com.ezen.vo.UserVO;

public class UserDAO {

	private static String path = "C:/test/member.txt";
	
	public UserVO getUser(String uid, String upw) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = null;
			while((line=br.readLine())!=null) {
				String[] info = line.split(" ");
				if(info[0].equals(uid) && info[1].equals(upw)) {
					br.close();
					return new UserVO(info[0],info[1]);
				}
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return null;
	}

	public boolean login(UserVO key) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String line = null;
			List<UserVO> list = new ArrayList<>();
			
			while((line=br.readLine())!= null) {
				System.out.println("line:"+line);
				UserVO user = new UserVO(line.split(" "));
				if(user.equals(key)) {
					user.setUid(key.getUid());
					user.setUpw(key.getUpw());
				}
				list.add(user);
			}
			br.close();
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean add(UserVO newUser) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(path,true));
			pw.println(newUser);
			pw.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(UserVO user) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = null;
			List<UserVO> list = new ArrayList<>();
			while((line=br.readLine())!=null) {
				UserVO fUser = new UserVO(line.split(" "));
				if(fUser.getUid().equals(user.getUid())) {
					list.add(user);
					continue;
				}
				list.add(fUser);
			}
			return overwrite(list);	//새로바뀐 정보를 기존의 정보에 덮어쓴다.
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean overwrite(List<UserVO> list) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(path));
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
